package ru.job4j;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class SingleTracker {

    private Tracker tracker = new Tracker();

    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    /* Остальные методы из класса Tracker. */
}