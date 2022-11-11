package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        ArrayList<Folder> rsl = new ArrayList<>();
        for (Folder lst : list) {
           if (pred.test(lst)) {
               rsl.add(lst);
           }
        }
       return rsl;
    }
}