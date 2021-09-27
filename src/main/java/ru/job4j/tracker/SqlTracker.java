package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        try (InputStream in =
                     SqlTracker.class
                     .getClassLoader()
                     .getResourceAsStream("app.properties")
        ) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driverClass"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public SqlTracker(Connection aConnection) {
        cn = aConnection;
    }

    @Override
    public Item add(Item item) {
        String query = "INSERT INTO tz_items (name) VALUES (?);";
        try (PreparedStatement st = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.execute();
            ResultSet keys = st.getGeneratedKeys();
            if (keys.next()) {
                item.setId(keys.getInt(1));
            }
            keys.close();
        } catch (SQLException ex) {
            System.out.println("Ошибка добавления заявки: " + ex);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        String query = "UPDATE tz_items SET name=? WHERE id=?;";
        boolean result = false;
        try (PreparedStatement st = cn.prepareStatement(query)) {
            st.setString(1, item.getName());
            st.setInt(2, id);
            int rowsCount = st.executeUpdate();
            result = rowsCount > 0;
        } catch (SQLException ex) {
            System.out.println("Ошибка при замене элемента: " + ex);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM tz_items WHERE id=?;";
        boolean result = false;
        try (PreparedStatement st = cn.prepareStatement(query)) {
            st.setInt(1, id);
            int rowsCount = st.executeUpdate();
            result = rowsCount > 0;
        } catch (SQLException ex) {
            System.out.println("Ошибка при удалении элемента: " + ex);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        String query = "SELECT * FROM tz_items;";
        try (PreparedStatement st = cn.prepareStatement(query)) {
            ResultSet s = st.executeQuery();
            while (s.next()) {
                Item entry = new Item(s.getInt("id"), s.getString("name"));
                entry.setCreated(s.getTimestamp("created"));
                result.add(entry);
            }
            s.close();
        } catch (SQLException ex) {
            System.out.println("Ошибка при получении всех элементов: " + ex);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        String query =
                "SELECT * FROM tz_items WHERE LOWER(name) LIKE '%" + key.toLowerCase() + "%';";
        List<Item> result = new ArrayList<>();
        try (Statement st = cn.createStatement()) {
            ResultSet s = st.executeQuery(query);
            while (s.next()) {
                Item entry = new Item(s.getInt("id"), s.getString("name"));
                entry.setCreated(s.getTimestamp("created"));
                result.add(entry);
            }
            s.close();
        } catch (SQLException ex) {
            System.out.println("Ошибка при поиске элементов по имени: " + ex);
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        String query = "SELECT * FROM tz_items WHERE id=?;";
        Item result = null;
        try (PreparedStatement st = cn.prepareStatement(query)) {
            st.setInt(1, id);
            ResultSet s = st.executeQuery();
            if (s.next()) {
                result = new Item(s.getInt("id"), s.getString("name"));
                result.setCreated(s.getTimestamp("created"));
            }
            s.close();
        } catch (SQLException ex) {
            System.out.println("Ошибка при поиске элемента по id:" + ex);
            System.out.println(query);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
