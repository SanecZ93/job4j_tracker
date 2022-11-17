package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            tmp.add(start + value.split("/")[0]);
            tmp.add(start + value);
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

   public static void sortDesc(List<String> orgs) {
       orgs.sort(new DepDescComp());
    }
}