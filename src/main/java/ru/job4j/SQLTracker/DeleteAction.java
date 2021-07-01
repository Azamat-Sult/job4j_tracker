package ru.job4j.SQLTracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int inputID = input.askInt("Please, enter ID of task to delete: ");
        if (tracker.delete(inputID)) {
            out.println("Deleting successful...");
        } else {
            out.println("Deleting failed...");
        }
        return true;
    }
}
