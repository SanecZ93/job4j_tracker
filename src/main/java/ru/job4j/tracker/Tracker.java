package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Objects;

public class Tracker {

    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return new ArrayList<>(items);
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (Objects.equals(item.getName(), key)) {
                result.add(item);
            }
        }
        return result;
    }

    public int indexOf(int id) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.set(index, null);
        }
        return rsl;
    }
}
