package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobComparatorsTest {
    @Test
    public void whenCmpByNameDescAndPriorityDesc1() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B", 10),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameDescAndPriorityDesc2() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 10),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameDescAndPriorityAsc1() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("A", 10)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameDescAndPriorityAsc2() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 1),
                new Job("A", 10)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameAscAndPriorityAsc1() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 1),
                new Job("B", 10)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameAscAndPriorityAsc2() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 1),
                new Job("A", 10)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameAscAndPriorityDesc1() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 10),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameAscAndPriorityDesc2() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 10),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameAsc() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("A", 1),
                new Job("B", 10)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameDesc() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("B", 10),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByPriorityAsc() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("A", 1),
                new Job("B", 10)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByPriorityDesc() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("B", 10),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
