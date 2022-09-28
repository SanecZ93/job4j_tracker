package ru.job4j.oop;

public class Train implements Vehicle {
    public void move() {
        System.out.println(getClass().getSimpleName() + " Перемещается по рельсам");
    }

    public void features() {
        System.out.println(getClass().getSimpleName() + " ходит змейкой");
    }
}
