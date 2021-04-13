package ru.job4j.lambda;

import java.util.*;

public class StrComparators {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> left.compareTo(right) ;
        Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();

        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("abc");
        list.add("ab");
        list.add("a");

        list.sort(cmpText);
        for (String s: list) {
            System.out.println(s);
        }

        list.sort(cmpDescSize);
        for (String s: list) {
            System.out.println(s);
        }
    }
}
