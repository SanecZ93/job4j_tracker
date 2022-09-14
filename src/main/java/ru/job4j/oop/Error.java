package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 128, "���� ���������(");
        Error error2 = new Error(true, 64, "��������� �������� ����!!!");
        Error error3 = new Error(false, 0, "����� ����� ������");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();

    }

    public void printInfo() {
        System.out.println("������ ������: " + active);
        System.out.println("����� ������: " + status + "��");
        System.out.println("��������� � �������������: " + message);
    }
}
