package com.company;

import java.util.Scanner;

public class CountByTwo {
    //Write a program that prompts a user to input a number and prints a count from 0 to that input.
    //Same as above, but counts by 2.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please pick a number for me to count to in increments of 2.");
        int userInput = scanner.nextInt();

        for (int i=0; i <= userInput; i+=2) {
            System.out.print(i + "\n");
        }
    }
}
