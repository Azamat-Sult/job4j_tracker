package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Length desc compare - " + left + " length: " + left.length()
                    + " vs " + right + " length: " + right.length());
            return right.length() - left.length();
        };

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("abc");
        list.add("abcd");

        list.sort(cmpDescSize);
        System.out.println("Sort result:");
        for (String s: list) {
            System.out.println(s);
        }
    }
}
