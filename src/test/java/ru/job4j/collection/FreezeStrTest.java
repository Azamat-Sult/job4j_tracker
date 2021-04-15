package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {
    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }

    @Test
    public void whenEq2() {
        assertThat(FreezeStr.eq("qqwwweeeerrrrrtttttty", "qwtertyqwertweertrrtt"), is(true));
    }

    @Test
    public void whenNotEq2() {
        assertThat(FreezeStr.eq("qqwwweeeerrrrrtttttty", "qwtertyqwertweertrrtz"), is(false));
    }

    @Test
    public void whenNotEq3() {
        assertThat(FreezeStr.eq("a", "z"), is(false));
    }
}
