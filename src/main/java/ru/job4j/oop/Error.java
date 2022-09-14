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
        Error error1 = new Error(true, 128, "мало оперативы(");
        Error error2 = new Error(true, 64, "оперативы ооочень мало!!!");
        Error error3 = new Error(false, 0, "синий экран смерти");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();

    }

    public void printInfo() {
        System.out.println("активность системы: " + active);
        System.out.println("объём памяти: " + status + "Мб");
        System.out.println("сообщение о неисправности: " + message);
    }
}
