package com.company;

import java.util.Scanner;

public class CountTo {
    //Write a program that prompts a user to input a number and prints a count from 0 to that input.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please pick a number for me to count to.");
        int userInput = scanner.nextInt();

        for (int i=0; i <= userInput; i++) {
            System.out.print(i + "\n");
        }
    }
}
