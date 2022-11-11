package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        ArrayList<Folder> rsl = new ArrayList<>();
        pred = s -> s.getName().contains("bug") || s.getSize() > 100;
        for (Folder s : list) {
           if (pred.test(s)) {
               rsl.add(s);
           }
        }
       return rsl;
    }
}