package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenShowAllItems() {
        String ln = System.lineSeparator();
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Item[] expected = new Item[] {new Item("Item 1"), new Item("Item 2")};
        Tracker tracker = new Tracker();
        tracker.add(expected[0]);
        tracker.add(expected[1]);
        UserAction[] actions = {
                new ShowAllAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu:" + ln +
                "0. Show all items" + ln +
                "1. Exit Program" + ln +
                "Item{id=1, name='Item 1', created=" + tracker.findAll()[0].getCurrentDateTime() + "}" + ln +
                "Item{id=2, name='Item 2', created=" + tracker.findAll()[1].getCurrentDateTime() + "}" + ln +
                "Menu:" + ln +
                "0. Show all items" + ln +
                "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old item name"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindById() {
        String ln = System.lineSeparator();
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item 1"));
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu:" + ln +
                "0. Find item by Id" + ln +
                "1. Exit Program" + ln +
                "Item{id=1, name='Item 1', created=" + tracker.findById(item.getId()).getCurrentDateTime() + "}" + ln +
                "Menu:" + ln +
                "0. Find item by Id" + ln +
                "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByName() {
        String ln = System.lineSeparator();
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item 1", "1"}
        );
        Item[] expected = new Item[] {new Item("Item 1"), new Item("Item 1")};
        Tracker tracker = new Tracker();
        tracker.add(expected[0]);
        tracker.add(expected[1]);
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu:" + ln +
                "0. Find items by name" + ln +
                "1. Exit Program" + ln +
                "Item{id=1, name='Item 1', created=" + tracker.findByName(expected[0].getName())[0].getCurrentDateTime()+ "}" + ln +
                "Item{id=2, name='Item 1', created=" + tracker.findByName(expected[1].getName())[0].getCurrentDateTime()+ "}" + ln +
                "Menu:" + ln +
                "0. Find items by name" + ln +
                "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenExit() {
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
                "Menu:" + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }
}