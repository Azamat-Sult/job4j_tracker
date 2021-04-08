package ru.job4j.trackerarraylist;

import java.util.List;

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
        List<Item> allItems = tracker.findAll();
        for (Item task : allItems) {
            out.println(task);
        }
        return true;
    }
}
