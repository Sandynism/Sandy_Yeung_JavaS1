package com.company;

import java.util.Scanner;

public class UltimateQuestion {
    //Write a program that continues to ask for input between 1 and 100 until the user enters 42.
    // Once they do, print "That's the number I was looking for! 42 is definitely the answer!"
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        int correctNum = 42;

        do {
            System.out.println("Please give me a number between 1 and 100");
            userInput = scanner.nextInt();
        } while (userInput != correctNum);
        if (userInput == correctNum) {
            System.out.println("That's the number I was looking for! 42 is definitely the answer!");
        }
    }
}
