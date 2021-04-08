package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftNumStr = left.split("\\.");
        String[] rightNumStr = right.split("\\.");
        int leftNum = Integer.parseInt(leftNumStr[0]);
        int rightNum = Integer.parseInt(rightNumStr[0]);
        return Integer.compare(leftNum, rightNum);
    }
}
