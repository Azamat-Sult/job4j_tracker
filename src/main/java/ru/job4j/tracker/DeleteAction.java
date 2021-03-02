package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputID = input.askInt("Please, enter ID of task to delete: ");
        if (tracker.delete(inputID)) {
            System.out.println("Deleting successful...");
        } else {
            System.out.println("Deleting failed...");
        }
        return true;
    }
}
