package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(new ArrayList<>(Arrays.asList("0", String.valueOf(one.getId()), replaceName, "1")));
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new ArrayList<>(Arrays.asList("0", "1")));
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAction(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new ArrayList<>(Arrays.asList("0", one.getName(), "1")));
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindNameAction(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new ArrayList<>(Arrays.asList("0", String.valueOf(one.getId()), "1")));
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindIdAction(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>(Arrays.asList("1", "0")));
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }
}

