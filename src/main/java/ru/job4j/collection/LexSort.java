package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] spl1 = left.split(". ");
        String[] spl2 = right.split(". ");
        return Integer.compare(Integer.parseInt(spl1[0]), Integer.parseInt(spl2[0]));
    }
}


