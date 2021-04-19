package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftHashMap = new HashMap<>();
        if (left.length() != right.length()) {
            return false;
        }
        for (int index = 0; index < left.length(); index++) {
            if (!leftHashMap.containsKey(left.charAt(index))) {
                leftHashMap.put(left.charAt(index), 1);
            } else {
                leftHashMap.put(left.charAt(index), leftHashMap.get(left.charAt(index)) + 1);
            }
        }
        for (int index = 0; index < right.length(); index++) {
            if (!leftHashMap.containsKey(right.charAt(index))) {
                return false;
            } else if (leftHashMap.get(right.charAt(index)) == 1) {
                leftHashMap.remove(right.charAt(index));
            } else {
                leftHashMap.put(right.charAt(index), leftHashMap.get(right.charAt(index)) - 1);
            }
        }
        return leftHashMap.isEmpty();
    }
}
