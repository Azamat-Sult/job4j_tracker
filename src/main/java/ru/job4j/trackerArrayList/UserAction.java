package ru.job4j.trackerArrayList;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
