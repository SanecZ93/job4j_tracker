package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.charAt(1) != o2.charAt(1)) {
            return Integer.compare(o2.charAt(1), o1.charAt(1));
        }
        int max = Math.min(o1.length(), o2.length());
        for (int index = 2; index < max; index++) {
            char a = o1.charAt(index);
            char b = o2.charAt(index);
            if (a > 47 && b < 58 && b > 47 && a != b) {
                return Integer.compare(a, b);
            }
        }
        return o1.length() < o2.length() ? -1 : 1;
    }
}