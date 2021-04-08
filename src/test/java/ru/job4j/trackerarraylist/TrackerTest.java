package ru.job4j.trackerarraylist;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item[] expect = new Item[2];

        Item item1 = new Item();
        item1.setName("test1");
        tracker.add(item1);
        expect[0] = item1;

        Item item2 = new Item();
        item2.setName("test1");
        tracker.add(item2);
        expect[1] = item2;

        Item item3 = new Item();
        item3.setName("test2");
        tracker.add(item3);

        List<Item> result = tracker.findByName("test1");
        assertThat(result.toArray(), is(expect));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}