package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("First task"));
        tracker.add(new Item("Second task"));
        tracker.add(new Item("Third task"));
        tracker.add(new Item("Fourth task"));
        Item someItem1 = tracker.findById(2);
        System.out.println("Task ID: " + someItem1.getId() + ", " + "Task name: " + someItem1.getName());
        Item someItem2 = tracker.findByName("Fourth task");
        System.out.println("Task ID: " + someItem2.getId() + ", " + "Task name: " + someItem2.getName());
    }
}
