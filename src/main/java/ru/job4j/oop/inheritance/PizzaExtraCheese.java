package ru.job4j.oop.inheritance;

public class PizzaExtraCheese extends Pizza {
    public String name() {
        return super.name() + " + extra cheese";
    }
}

