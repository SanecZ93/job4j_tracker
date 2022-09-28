package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("going to town");
    }

    @Override
    public void passenger() {
        System.out.println(24);
    }

    @Override
    public void refuel(int question) {
        int price = 24;
        Bus bus = new Bus();
        bus.refuel(120 * price);
    }
}
