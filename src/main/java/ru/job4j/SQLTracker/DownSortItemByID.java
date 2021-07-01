package ru.job4j.SQLTracker;

import java.util.Comparator;

public class DownSortItemByID implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(second.getId(), first.getId());
    }
}
