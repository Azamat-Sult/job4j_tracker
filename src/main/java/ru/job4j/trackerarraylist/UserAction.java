package ru.job4j.trackerarraylist;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
