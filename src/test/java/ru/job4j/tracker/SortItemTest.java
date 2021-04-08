package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SortItemTest {

    @Test
    public void upSortItemByID() {
        Item first = new Item(1, "First");
        Item second = new Item(2, "Second");
        Item third = new Item(3, "Third");
        List<Item> itemsBefore = Arrays.asList(third, second, first);
        List<Item> itemsAfter = Arrays.asList(first, second, third);
        Collections.sort(itemsBefore, new UpSortItemByID());
        assertThat(itemsBefore, is(itemsAfter));
    }

    @Test
    public void downSortItemByID() {
        Item first = new Item(1, "First");
        Item second = new Item(2, "Second");
        Item third = new Item(3, "Third");
        List<Item> itemsBefore = Arrays.asList(first, second, third);
        List<Item> itemsAfter = Arrays.asList(third, second, first);
        Collections.sort(itemsBefore, new DownSortItemByID());
        assertThat(itemsBefore, is(itemsAfter));
    }

    @Test
    public void upSortItemByName() {
        Item a = new Item(1, "A");
        Item b = new Item(2, "B");
        Item c = new Item(3, "C");
        List<Item> itemsBefore = Arrays.asList(c, b, a);
        List<Item> itemsAfter = Arrays.asList(a, b, c);
        Collections.sort(itemsBefore, new UpSortItemByName());
        assertThat(itemsBefore, is(itemsAfter));
    }

    @Test
    public void downSortItemByName() {
        Item a = new Item(1, "A");
        Item b = new Item(2, "B");
        Item c = new Item(3, "C");
        List<Item> itemsBefore = Arrays.asList(a, b, c);
        List<Item> itemsAfter = Arrays.asList(c, b, a);
        Collections.sort(itemsBefore, new DownSortItemByName());
        assertThat(itemsBefore, is(itemsAfter));
    }
}