package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "==== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputID = input.askInt("Please, enter ID of task to find: ");
        Item foundItem = tracker.findById(inputID);
        if (foundItem != null) {
            System.out.println(foundItem);
        } else System.out.println("A task with this ID was not found");
        return true;
    }
}
