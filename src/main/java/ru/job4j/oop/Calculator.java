package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return y + x;
    }

    public int multiply(int y) {

        return y * x;
    }

    public static int minus(int y) {

        return y - x;
    }

    public int divide(int y) {

        return y / x;
    }

    public int sumAllOperation(int sum, int multiply, int minus, int divide) {
        return sum + multiply + minus + divide;
    }

    public static void main(String[] args) {
        int rslSum = sum(10);
        System.out.println(rslSum);
        Calculator calculator = new Calculator();
        int rslMultiply = calculator.multiply(5);
        System.out.println(rslMultiply);
        int rslMinus = minus(2);
        System.out.println(rslMinus);
        int rslDivide = calculator.divide(10);
        System.out.println(rslDivide);
        int rslScore = calculator.sumAllOperation(rslSum, rslMultiply, rslMinus, rslDivide);
        System.out.println(rslScore);
    }
}
