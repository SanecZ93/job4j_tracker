package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSe {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        autos.add("BMW");
        autos.add("Lada");
        autos.add("Volvo");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
