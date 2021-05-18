package ru.job4j.collection.departments;

import org.junit.Test;
import ru.job4j.collection.departments.Departments;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortAsc() {
        List<String> input = Arrays.asList(
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K2"
        );
        List<String> expected = Arrays.asList(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        List<String> result = Departments.fillGaps(input);
        Departments.sortAsc(result);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = Arrays.asList(
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K2"
        );
        List<String> expected = Arrays.asList(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2"
        );
        List<String> result = Departments.fillGaps(input);
        Departments.sortDesc(result);
        assertThat(result, is(expected));
    }

}