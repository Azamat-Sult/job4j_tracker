package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("==== Show all items ====");
                Item[] allItems = tracker.findAll();
                for (int index = 0; index < allItems.length; index++) {
                    System.out.println(allItems[index]);
                }
            } else if (select == 2) {
                System.out.println("==== Edit item ====");
                int inputID = input.askInt("Please, enter ID of task to edit: ");
                String newName = input.askStr("Please, enter new task to edit: ");
                Item newItem = new Item(newName);
                if (tracker.replace(inputID, newItem)) {
                    System.out.println("Replacement successful...");
                } else {
                    System.out.println("Replacement failed...");
                }
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                int inputID = input.askInt("Please, enter ID of task to delete: ");
                if (tracker.delete(inputID)) {
                    System.out.println("Deleting successful...");
                } else {
                    System.out.println("Deleting failed...");
                }
            } else if (select == 4) {
                System.out.println("==== Find item by Id ====");
                int inputID = input.askInt("Please, enter ID of task to find: ");
                Item foundItem = tracker.findById(inputID);
                if (foundItem != null) {
                    System.out.println(foundItem);
                } else System.out.println("A task with this ID was not found");
            } else if (select == 5) {
                System.out.println("==== Find items by name ====");
                String targetName = input.askStr("Please, enter tasks name to find: ");
                Item[] foundByName = tracker.findByName(targetName);
                if (foundByName.length != 0) {
                    for (int index = 0; index < foundByName.length; index++) {
                        System.out.println(foundByName[index]);
                    }
                } else System.out.println("A tasks with this name was not found");
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("===== Menu =====");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}