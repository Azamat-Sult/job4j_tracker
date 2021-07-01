package ru.job4j.SQLTracker;

import java.util.Comparator;

public class UpSortItemByName implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
