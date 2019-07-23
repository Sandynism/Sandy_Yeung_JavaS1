package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        //Subtract the second number from the first number inputted by the user.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me a random number");
        int num1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please give me a second random number");
        int num2 = Integer.parseInt(scanner.nextLine());

        int subtractSecondNum = (num1 - num2);
        System.out.println(subtractSecondNum);
    }
}
