package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.closeTo;

public class PointTest {

    @Test
    public void distanceWhenX0Y0toX4Y0Then4() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(4, 0.001));
    }

    @Test
    public void distanceWhenX2Y3toXminus5Y16Then14dot764() {
        Point a = new Point(2, 3);
        Point b = new Point(-5, 16);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(14.764, 0.001));
    }

    @Test
    public void distanceWhenX2Y3toX2Y3Then0() {
        Point a = new Point(2, 3);
        Point b = new Point(2, 3);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(0, 0.001));
    }
}