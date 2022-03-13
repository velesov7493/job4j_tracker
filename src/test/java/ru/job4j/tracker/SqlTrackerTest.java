package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    private static void initDatabase(Connection cn, String sqlResourceName) {
        String sql = "";
        try (InputStream inSQL =
                     SqlTrackerTest.class
                             .getClassLoader()
                             .getResourceAsStream(sqlResourceName)
        ) {
            if (inSQL != null) {
                sql = new String(inSQL.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (Throwable ex) {
            throw new IllegalStateException(
                    "Критическая ошибка - невозможно прочитать sql-скрипт инициализации!", ex
            );
        }
        try (
                PreparedStatement ps = cn.prepareStatement(sql)
        ) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new IllegalStateException("Ошибка при выполнении sql-скрипта инициализации!", ex);
        }
    }

    @BeforeClass
    public static void initConnection() {
        try (InputStream in =
                     SqlTrackerTest.class
                             .getClassLoader()
                             .getResourceAsStream("app.properties")
        ) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driverClass"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
            String sqlInitResource = config.getProperty("initScript");
            if (sqlInitResource != null) {
                initDatabase(connection, sqlInitResource);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from tz_items;")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindAll() {
        List<Item> expected = List.of(
                new Item(1, "item1"),
                new Item(2, "item2")
        );
        SqlTracker tracker = new SqlTracker(connection);
        expected.forEach(tracker::add);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenFindById() {
        List<Item> in = List.of(
                new Item(1, "item1"),
                new Item(2, "item2")
        );
        Item expected = in.get(1);
        SqlTracker tracker = new SqlTracker(connection);
        in.forEach(tracker::add);
        int id = expected.getId();
        assertThat(tracker.findById(id), is(expected));
    }

    @Test
    public void whenFindByName() {
        List<Item> in = List.of(
                new Item(1, "item1"),
                new Item(2, "item2")
        );
        List<Item> expected = List.of(in.get(1));
        SqlTracker tracker = new SqlTracker(connection);
        in.forEach(tracker::add);
        assertThat(tracker.findByName("item2"), is(expected));
    }

    @Test
    public void whenDelete() {
        List<Item> expected = List.of(
                new Item(1, "item1")
        );
        Item deleted = new Item(2, "item2");
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(expected.get(0));
        deleted = tracker.add(deleted);
        tracker.delete(deleted.getId());
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenReplace() {
        List<Item> in = List.of(
                new Item(1, "item1"),
                new Item(2, "item2")
        );
        SqlTracker tracker = new SqlTracker(connection);
        in.forEach(tracker::add);
        int id = in.get(1).getId();
        Item replacement = new Item(id, "ReplaceItem");
        tracker.replace(id, replacement);
        assertThat(tracker.findById(id), is(replacement));
    }
}