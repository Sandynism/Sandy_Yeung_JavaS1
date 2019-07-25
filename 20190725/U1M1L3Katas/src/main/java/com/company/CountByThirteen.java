package com.company;

import java.util.Scanner;

public class CountByThirteen {
    //Write a program that prompts a user to input a number and prints a count from 0 to that input.
    //Same as above, but counts by 13.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please pick a number for me to count to in increments of 13.");
        int userInput = scanner.nextInt();

        for (int i=0; i <= userInput; i+=13) {
            System.out.print(i + "\n");
        }
    }
}