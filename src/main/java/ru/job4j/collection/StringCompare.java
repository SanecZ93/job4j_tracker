package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length(); i++) {
            if (Integer.compare(left.charAt(i), right.charAt(i))) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        return rsl;
    }
}