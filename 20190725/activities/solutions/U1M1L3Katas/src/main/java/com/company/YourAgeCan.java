package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your age:");
        String input = scanner.nextLine();
        int age = Integer.parseInt(input);

        if (age >= 18) {
            System.out.println("You can vote!");
        }

        if (age >= 21) {
            System.out.println("You can drink alcohol.");
        }

        if (age >= 35) {
            System.out.println("You can be president!");
        }

        if (age >= 55) {
            System.out.println("You're eligible for AARP!");
        }

        if (age >= 65) {
            System.out.println("You can retire!");
        }

        if (age >= 80 && age < 90) {
            System.out.println("You are an octogenerian!");
        }

        if (age >= 100) {
            System.out.println("Wow!  You made it through an entire century!");
        }

    }
}
