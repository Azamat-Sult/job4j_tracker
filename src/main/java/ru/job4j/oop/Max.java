package ru.job4j.oop;

public class Max {

    public static int maxOf(int first, int second) {
        return first >= second ? first : second;
    }

    public static int maxOf(int first, int second, int third) {
        return maxOf(first, maxOf(second, third));
    }

    public static int maxOf(int first, int second, int third, int fourth) {
        return maxOf(first, maxOf(second, maxOf(third, fourth)));
    }
}
