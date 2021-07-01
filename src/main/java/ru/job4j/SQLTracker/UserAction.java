package ru.job4j.SQLTracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
