package com.company;

import java.util.Scanner;

public class RangeChecker {
    //Write a program that asks the user for a number between 15 and 32 (not inclusive).
    // The program must continue to prompt the user until they provide a number that is in range.
    // Then, once they do, output the number to the console.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userGuess;
        do {
            System.out.println("Please guess a number between 15 and 32.");
            userGuess = scanner.nextInt();
        } while ((userGuess < 15) || (userGuess > 32));
        if ((userGuess > 15) && (userGuess < 32)) {
            System.out.println("You win! Your guess was " + userGuess);
        }
    }
}
