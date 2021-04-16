package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList(Arrays.asList(-10, 5, 34, -8, 100, -32));
        List<Integer> positive = data.stream().filter(num -> num > 0).collect(Collectors.toList());
        for (Integer element : positive) {
            System.out.println(element);
        }
    }
}
