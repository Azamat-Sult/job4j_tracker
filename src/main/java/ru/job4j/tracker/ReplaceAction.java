package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputID = input.askInt("Please, enter ID of task to edit: ");
        String newName = input.askStr("Please, enter new task to edit: ");
        Item newItem = new Item(newName);
        if (tracker.replace(inputID, newItem)) {
            System.out.println("Replacement successful...");
        } else {
            System.out.println("Replacement failed...");
        }
        return true;
    }
}
