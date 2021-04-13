package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class FunctionsInRangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionsInRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionsInRange.diapason(5, 8, x -> x * x * 10);
        List<Double> expected = Arrays.asList(250D, 360D, 490D, 640D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionsInRange.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D, 256D);
        assertThat(result, is(expected));
    }

}
