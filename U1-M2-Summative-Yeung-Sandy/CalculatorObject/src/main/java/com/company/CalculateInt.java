package com.company;

public class CalculateInt {

    public int addition(int a, int b) {
        int c = a + b;
        System.out.printf("%d + %d = %d%n", a, b, c);
        return c;
    }

    public int subtraction(int a, int b) {
        int c = a - b;
        System.out.printf("%d - %d = %d%n", a, b, c);
        return c;
    }

    public int multiplication(int a, int b) {
        int c = a * b;
        System.out.printf("%d * %d = %d%n", a, b, c);
        return c;
    }

    public int division(int a, int b) {
        int c = a / b;
        System.out.printf("%d / %d = %d%n", a, b, c);
        return c;
    }
}
