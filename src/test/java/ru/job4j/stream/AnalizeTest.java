package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void diff() {
        Analize.User user1 = new Analize.User(1, "A");
        Analize.User user2 = new Analize.User(2, "B");
        Analize.User user3 = new Analize.User(3, "C");
        Analize.User user4 = new Analize.User(4, "D");
        Analize.User user5 = new Analize.User(5, "E");
        Analize.User user6 = new Analize.User(4, "DE");
        Analize.User user7 = new Analize.User(6, "F");
        List<Analize.User> before = new ArrayList<>();
        before.add(user1);
        before.add(user2);
        before.add(user3);
        before.add(user4);
        List<Analize.User> after = new ArrayList<>();
        after.add(user2);
        after.add(user3);
        after.add(user6);
        after.add(user5);
        after.add(user7);
        Analize.Info expect = new Analize.Info(2, 1, 1);
        Analize anlz = new Analize();
        assertThat(expect, is(anlz.diff(before, after)));
    }
}