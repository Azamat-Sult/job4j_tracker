package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        String item = "New Item";
        Input in = new StubInput(
                new String[] {"0", item, "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is(item));
    }

    @Test
    public void whenShowAllItems() {
        String ln = System.lineSeparator();
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Item item1 = new Item("Item 1");
        Item item2 = new Item("Item 2");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        UserAction[] actions = {
                new ShowAllAction(output),
                new ExitAction()
        };
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
        Input in = new StubInput(
                new String[] {"0", String.valueOf(oldItem.getId()), newItem, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(oldItem.getId()).getName(), is(newItem));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Item itemToDelete = new Item("Item to delete");
        Tracker tracker = new Tracker();
        tracker.add(itemToDelete);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(itemToDelete.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
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
        Input in = new StubInput(
                new String[] {"0", String.valueOf(itemToFind.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction()
        };
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
        Input in = new StubInput(
                new String[] {"0", itemNameToFind, "1"}
        );
        Item item1 = new Item(itemNameToFind);
        Item item2 = new Item(itemNameToFind);
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction()
        };
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
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
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
        Input in = new StubInput(
                new String[] {"10", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit Program" + ln
                )
        ));
    }
}