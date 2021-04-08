package ru.job4j.trackerarraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        String item = "New Item";
        List<String> input = new ArrayList<>();
        input.add("0");
        input.add(item);
        input.add("1");
        Input in = new StubInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(item));
    }

    @Test
    public void whenShowAllItems() {
        String ln = System.lineSeparator();
        Output output = new StubOutput();
        List<String> input = new ArrayList<>();
        input.add("0");
        input.add("1");
        Input in = new StubInput(input);
        Item item1 = new Item("Item 1");
        Item item2 = new Item("Item 2");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + item1.toString() + ln
                + item2.toString() + ln
                + "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Item oldItem = new Item("Old item name");
        Tracker tracker = new Tracker();
        tracker.add(oldItem);
        String newItem = "New item name";
        List<String> input = new ArrayList<>();
        input.add("0");
        input.add(String.valueOf(oldItem.getId()));
        input.add(newItem);
        input.add("1");
        Input in = new StubInput(input);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(oldItem.getId()).getName(), is(newItem));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Item itemToDelete = new Item("Item to delete");
        Tracker tracker = new Tracker();
        tracker.add(itemToDelete);
        List<String> input = new ArrayList<>();
        input.add("0");
        input.add(String.valueOf(itemToDelete.getId()));
        input.add("1");
        Input in = new StubInput(input);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(itemToDelete.getId()), is(nullValue()));
    }

    @Test
    public void whenFindById() {
        String ln = System.lineSeparator();
        Output output = new StubOutput();
        Item itemToFind = new Item("Item to find by id");
        Tracker tracker = new Tracker();
        tracker.add(itemToFind);
        List<String> input = new ArrayList<>();
        input.add("0");
        input.add(String.valueOf(itemToFind.getId()));
        input.add("1");
        Input in = new StubInput(input);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu:" + ln
                + "0. Find item by Id" + ln
                + "1. Exit Program" + ln
                + itemToFind.toString() + ln
                + "Menu:" + ln
                + "0. Find item by Id" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByName() {
        String ln = System.lineSeparator();
        Output output = new StubOutput();
        String itemNameToFind = "Item 1";
        List<String> input = new ArrayList<>();
        input.add("0");
        input.add(itemNameToFind);
        input.add("1");
        Input in = new StubInput(input);
        Item item1 = new Item(itemNameToFind);
        Item item2 = new Item(itemNameToFind);
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
                + item1.toString() + ln
                + item2.toString() + ln
                + "Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenExit() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        List<String> input = new ArrayList<>();
        input.add("0");
        Input in = new StubInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        List<String> input = new ArrayList<>();
        input.add("10");
        input.add("0");
        Input in = new StubInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
        ));
    }
}