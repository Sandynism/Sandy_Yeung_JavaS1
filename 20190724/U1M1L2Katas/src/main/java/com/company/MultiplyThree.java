package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        //Multiply 3 numbers inputted by the user.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me a random number");
        int num1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please give me a second random number");
        int num2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please give me a third random number");
        int num3 = Integer.parseInt(scanner.nextLine());

        double multiply = (num1 * num2 * num3);
        System.out.println(multiply);

    }
}