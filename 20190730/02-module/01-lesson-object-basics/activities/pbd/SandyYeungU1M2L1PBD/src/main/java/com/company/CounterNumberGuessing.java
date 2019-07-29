package com.company;

import java.util.Random;
import java.util.Scanner;

public class CounterNumberGuessing {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner scanner = new Scanner(System.in);

        int counter= 1;

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        int randomNum = randomGenerator.nextInt((10 - 1) + 1) + 1;
        int userGuess = Integer.parseInt(scanner.nextLine());
        System.out.printf("Your guess: %d%n", userGuess);

        while (randomNum != userGuess) {
            System.out.println("That is incorrect. Guess again.");
            userGuess = Integer.parseInt(scanner.nextLine());
            System.out.printf("Your guess: %d%n", userGuess);
            counter++;
        }
        if (randomNum == userGuess) {
            System.out.println("That's right! You're a good guesser.");
            System.out.printf("It only took you %d tries.", counter);
        }
    }
}

//Modify your previous number-guessing game so that they can guess until they get it right AND count the number of tries it takes them to guess it.
//
//I have chosen a number between 1 and 10.  Try to guess it.
//Your guess: 5
//That is incorrect.  Guess again.
//Your guess: 4
//That is incorrect.  Guess again.
//Your guess: 8
//That is incorrect.  Guess again.
//Your guess: 6
//That's right!  You're a good guesser.
//It only took you 4 tries.