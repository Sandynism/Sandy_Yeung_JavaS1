package com.company;

public class CalculateDouble {

    public double addition(double a, double b) {
        double c = a + b;
        System.out.printf("%.1f + %.1f = %.1f%n", a, b, c);
        return c;
    }

    public double subtraction(double a, double b) {
        double c = a - b;
        System.out.printf("%.1f - %.1f = %.1f%n", a, b, c);
        return c;
    }

    public double multiplication(double a, double b) {
        double c = a * b;
        System.out.printf("%.1f * %.1f = %.1f%n", a, b, c);
        return c;
    }

    public double division(double a, double b) {
        double c = a / b;
        System.out.printf("%.1f / %.1f = %.1f%n", a, b, c);
        return c;
    }
}

//In this exercise, you will create an object that has a set of methods that does addition, subtraction, multiplication, and division for tow double parameters and a separate set of methods that does the same for two double parameters. You will then instantiate the object and use it to perform the following calculations. You must print out the calculation being performed and the result of the calculation. For example: 2 + 2 = 4
//
//Create your solution in an IntelliJ project called ```CalculatorObject```.
//
//* 1 + 1
//* 23 - 52
//* 34 * 2
//* 12 / 3
//* 12 / 7
//* 3.4 + 2.3
//* 6.7 * 4.4
//* 5.5 - 0.5
//* 10.8 / 2.2