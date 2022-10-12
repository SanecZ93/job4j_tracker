package ru.job4j.ooa;

import java.util.Objects;

final public class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

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
        System.out.println("������ ��������: " + name);
    }

    public void printCountEngine() {
        int OTHER_ENGINE = 4;
        if (Objects.equals(name, "A380")) {
            System.out.println("���������� ���������� �����: " + 4);
        } else {
            System.out.println("���������� ���������� �����: " + COUNT_ENGINE);
        }
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
