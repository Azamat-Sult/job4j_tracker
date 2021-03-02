package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputID = input.askInt("Please, enter ID of task to find: ");
        Item foundItem = tracker.findById(inputID);
        if (foundItem != null) {
            out.println(foundItem);
        } else out.println("A task with this ID was not found");
        return true;
    }
}
