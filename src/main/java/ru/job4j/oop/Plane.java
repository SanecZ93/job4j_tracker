package ru.job4j.oop;

public class Plane implements Vehicle {
    public void move() {
        System.out.println(getClass().getSimpleName() + " Перемещается по воздуху");
    }

    @Override
    public void features() {
        System.out.println(getClass().getSimpleName() + " выглядит, как большая птица");
    }
}
