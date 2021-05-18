package ru.job4j.collection.departments;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class DepartmentsDescCompTest {

    @Test
    public void compare() {
        int result = new DepartmentsDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int result = new DepartmentsDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(result, lessThan(0));
    }
}