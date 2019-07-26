package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        do {
            System.out.println("Please enter a number between 15 and 32:");
            String inputString = scanner.nextLine();
            input = Integer.parseInt(inputString);
        } while (input < 15 || input > 32);

        System.out.println("You typed in: " + input);
    }
}
