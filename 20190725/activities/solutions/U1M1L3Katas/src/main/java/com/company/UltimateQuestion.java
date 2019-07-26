package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        String input = "";

        do {
            System.out.println("Please enter a number:");
            input = scanner.nextLine();
            number = Integer.parseInt(input);
        } while (number != 42);

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
