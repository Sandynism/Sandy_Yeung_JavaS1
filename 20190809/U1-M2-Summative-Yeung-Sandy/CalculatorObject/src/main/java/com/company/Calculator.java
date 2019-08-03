package com.company;

public class Calculator {
    public static void main(String[] args) {
        CalculateInt calcInt = new CalculateInt();
        CalculateDouble calcDouble = new CalculateDouble();

        calcInt.addition(22, 3);
        calcInt.subtraction(8, 15);
        calcInt.multiplication(100, 5);
        calcInt.division(60, 2);

        calcDouble.addition(200.0, 315.6);
        calcDouble.subtraction(75.8, 35.7);
        calcDouble.multiplication(35.9, 4.4);
        calcDouble.division(66.0, 28.3);
    }
}
