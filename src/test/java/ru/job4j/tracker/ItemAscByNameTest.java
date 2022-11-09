package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {

    @Test
    public void whenAverageScore() {
        List<Item> items = new ArrayList<>(List.of(new Item("Pavel"),
                new Item("Alex"),
                new Item("Ivan"),
                new Item("Vlad"))
        );
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>(List.of(new Item("Alex"),
                new Item("Ivan"),
                new Item("Pavel"),
                new Item("Vlad"))
        );
        assertThat(items).isEqualTo(expected);
    }
}