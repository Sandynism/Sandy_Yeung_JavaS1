package com.company;

import java.util.Random;
import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int rollValue;

        for (int i = 0; i < 3; i++) {
            rollValue = randomGenerator.nextInt(10) + 1;
            System.out.println("I'm thinking of a number from 1 to 10.");
            int userGuess = Integer.parseInt(scanner.nextLine());

            if (userGuess == rollValue) {
                System.out.printf("That's correct! %d was the number I was thinking of!%n", userGuess);
            } else {
                System.out.printf("Sorry, but I was really thinking %d.%n", rollValue);
            }
        }

    }
}

//Modify your incredibly stupid number-guessing game to actually pick a random number from 1 to 10 and have the user try to guess that. Tell them if they get it right or wrong, and if they get it wrong, show them what the random number was.
//
//They will still only get one try.
//
//I'm thinking of a number from 1 to 10.
//Your guess: 3
//
//Sorry, but I was really thinking of 4.
//
//
//I'm thinking of a number from 1 to 10.
//Your guess: 4
//
//Sorry, but I was really thinking of 7.
//
//
//I'm thinking of a number from 1 to 10.
//Your guess: 2
//
//That's right!  My secret number was 2!