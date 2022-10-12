package ru.job4j.ooa;

import java.util.Objects;

public class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    private static final int A380_ENGINE = 4;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолёта: " + name);
    }

    public void printCountEngine() {
        String engine = Objects.equals(name, "A380")
                ? "Количество двигателей равно: " + A380_ENGINE
                : "Количество двигателей равно: " + COUNT_ENGINE;
        System.out.println(engine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}