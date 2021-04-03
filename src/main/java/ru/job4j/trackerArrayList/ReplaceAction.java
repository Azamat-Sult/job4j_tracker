package ru.job4j.trackerArrayList;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputID = input.askInt("Please, enter ID of task to edit: ");
        String newName = input.askStr("Please, enter new task to edit: ");
        Item newItem = new Item(newName);
        if (tracker.replace(inputID, newItem)) {
            out.println("Replacement successful...");
        } else {
            out.println("Replacement failed...");
        }
        return true;
    }
}
