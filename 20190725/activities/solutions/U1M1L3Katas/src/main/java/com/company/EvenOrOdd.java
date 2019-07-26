package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        System.out.println("Please enter a number:");
        String input = scanner.nextLine();
        number = Integer.parseInt(input);

        if ((number % 2) == 0) {
            System.out.println("Even.");
        } else {
            System.out.println("Odd.");
        }
    }
}
