package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test
    public void when5then120() {
        int rsl = Fact.calc(5);
        assertThat(rsl, is(120));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMinus5thenException() {
        int rsl = Fact.calc(-5);
    }
}