package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("����� ����� ��������");
        } else if (position == 2) {
            System.out.println("��������� ����");
    } else {
            System.out.println("����� �� �������");
        }
    }

        public static void main(String[] args) {
        Jukebox petya = new Jukebox();
        int position = 1;
        petya.music(position);
    }
}
