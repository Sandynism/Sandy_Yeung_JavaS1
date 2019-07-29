package com.company;

import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        int randomNum = randomGenerator.nextInt((10 - 1) + 1) + 1;
        int userGuess = Integer.parseInt(scanner.nextLine());

        while (randomNum != userGuess) {
            System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
            userGuess = Integer.parseInt(scanner.nextLine());
        }
        if (randomNum == userGuess) {
            System.out.println("That's right! You're a good guesser.");
        }
    }
}

//Modify your previous number-guessing game so that they can guess until they get it right. That means it will keep looping as long as the guess is different from the secret number. Use a while loop.
//
//I have chosen a number between 1 and 10. Try to guess it.
//Your guess: 5
//That is incorrect. Guess again.
//Your guess: 4
//That is incorrect. Guess again.
//Your guess: 8
//That is incorrect. Guess again.
//Your guess: 6
//That's right! You're a good guesser.