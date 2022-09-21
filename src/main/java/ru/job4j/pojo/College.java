package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Smirnov Gleb Pavlovich");
        student.setGroup(333);
        student.setData("August 22, 2022");
        String ln = System.lineSeparator();
        System.out.println("Fio: " + student.getFio() + ln + "Group: "
                + student.getGroup() + ln + "Data: " + student.getData());
    }
}
