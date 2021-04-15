package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> leftHashMap = new HashMap<>();
        Map<Character, Integer> rightHashMap = new HashMap<>();
        for (int index = 0; index < left.length(); index++) {
            if (!leftHashMap.containsKey(left.charAt(index))) {
                leftHashMap.put(left.charAt(index), 1);
            } else leftHashMap.put(left.charAt(index), leftHashMap.get(left.charAt(index)) + 1);
            if (!rightHashMap.containsKey(right.charAt(index))) {
                rightHashMap.put(right.charAt(index), 1);
            } else rightHashMap.put(right.charAt(index), rightHashMap.get(right.charAt(index)) + 1);
        }
        for (Character key: leftHashMap.keySet()) {
            if (!leftHashMap.get(key).equals(rightHashMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}
