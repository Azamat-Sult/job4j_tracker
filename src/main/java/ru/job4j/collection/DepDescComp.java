package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Splited = o1.split("/");
        String[] o2Splited = o2.split("/");
        int rsl = o2Splited[0].compareTo(o1Splited[0]);
        if (rsl == 0) {
            rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}
