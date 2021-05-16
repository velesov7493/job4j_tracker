package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePetrVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareIvan33VSIvan32() {
        int rsl = new User("Ivan", 33)
                .compareTo(
                        new User("Ivan", 32)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareIvan32VSIvan35() {
        int rsl = new User("Ivan", 32)
                .compareTo(
                        new User("Ivan", 35)
                );
        assertThat(rsl, lessThan(0));
    }

}