package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void maxOfWhen1and2Then2() {
        int result = Max.maxOf(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void maxOfWhen1and3and0Then3() {
        int result = Max.maxOf(1, 3, 0);
        assertThat(result, is(3));
    }

    @Test
    public void maxOfWhen1and3and10andMinus5Then10() {
        int result = Max.maxOf(1, 3, 10, -5);
        assertThat(result, is(10));
    }
}