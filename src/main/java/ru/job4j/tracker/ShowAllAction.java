package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "==== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (int index = 0; index < allItems.length; index++) {
            System.out.println(allItems[index]);
        }
        return true;
    }
}
