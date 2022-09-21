package ru.job4j.pojo;

import java.util.Objects;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 0);
        Book book2 = new Book("War and world", 1300);
        Book book3 = new Book("Stalker", 192);
        Book book4 = new Book("Regulation", 480);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("        shuffling books:");
        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getPages());
        }

        System.out.println("        book search:");
        for (Book bk : books) {
            if (Objects.equals(bk.getName(), "Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}
