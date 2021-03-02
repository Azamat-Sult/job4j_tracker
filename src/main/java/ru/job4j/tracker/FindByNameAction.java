package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String targetName = input.askStr("Please, enter tasks name to find: ");
        Item[] foundByName = tracker.findByName(targetName);
        if (foundByName.length != 0) {
            for (int index = 0; index < foundByName.length; index++) {
                System.out.println(foundByName[index]);
            }
        } else System.out.println("A tasks with this name was not found");
        return true;
    }
}
