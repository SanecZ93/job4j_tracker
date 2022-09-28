package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public boolean drive(String question) {
        return false;
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
