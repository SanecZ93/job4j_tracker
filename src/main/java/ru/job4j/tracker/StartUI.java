package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item {
    public static void main(String[] args) {
        Item item = new Item(1, "user");
        LocalDateTime data = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dataFormat = data.format(formatter);
        System.out.println(dataFormat);
        System.out.println(item);
    }
}