package ru.job4j.sqltracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String targetName = input.askStr("Please, enter tasks name to find: ");
        List<Item> foundByName = tracker.findByName(targetName);
        if (foundByName.size() != 0) {
            for (Item item : foundByName) {
                out.println(item);
            }
        } else {
            out.println("A tasks with this name was not found");
        }
        return true;
    }
}
