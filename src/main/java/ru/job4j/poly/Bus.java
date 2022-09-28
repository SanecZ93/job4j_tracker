package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("going to town");
    }

    @Override
    public int passenger(String question) {
        return 30;
    }

    @Override
    public int fuel(String question) {
        return 120 * 24;
    }
}
