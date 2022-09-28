package ru.job4j.oop;

public class Bus implements Vehicle {
    public void move() {
        System.out.println(getClass().getSimpleName() + " Перемещается по дороге");
    }

    public void features() {
        System.out.println(getClass().getSimpleName() + " скачет по кочкам");
    }
}
