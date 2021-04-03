package ru.job4j.trackerArrayList;

import java.util.ArrayList;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> allItems = tracker.findAll();
        for (Item task : allItems) {
            out.println(task);
        }
        return true;
    }
}
