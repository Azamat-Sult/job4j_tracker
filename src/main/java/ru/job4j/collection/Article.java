package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> origSet = new HashSet<>();
        Set<String> lineSet = new HashSet<>();
        Collections.addAll(origSet, origin.replaceAll("\\p{Punct}", "").split(" "));
        Collections.addAll(lineSet, line.replaceAll("\\p{Punct}", "").split(" "));
        return origSet.containsAll(lineSet);
    }
}
