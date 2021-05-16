package ru.job4j.collection.comparators;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenAscByNameComparator() {
        Comparator<Job> cmpName = new JobAscByName();
        int result = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(result > 0);
    }

    @Test
    public void whenAscByPriorityComparator() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int result = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(result < 0);
    }

    @Test
    public void whenDescByNameComparator() {
        Comparator<Job> cmpName = new JobDescByName();
        int result = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(result < 0);
    }

    @Test
    public void whenDescByPriorityComparator() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int result = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(result > 0);
    }

    @Test
    public void whenCompatorByNameDescAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAscAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDescAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAscAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDescAndProrityAscSameNames() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAscAndProrityDescSameNames() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(result, greaterThan(0));
    }
}