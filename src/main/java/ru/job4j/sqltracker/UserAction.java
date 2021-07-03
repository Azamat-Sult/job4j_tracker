package ru.job4j.sqltracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
