package ru.job4j.sqltracker;

import java.util.Comparator;

public class UpSortItemByID implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(first.getId(), second.getId());
    }
}
