package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
    }

    @Override
    public void passenger() {
        System.out.println(24);
    }

    @Override
    public int fuel(String question) {
        return 120 * 24;
    }
}
