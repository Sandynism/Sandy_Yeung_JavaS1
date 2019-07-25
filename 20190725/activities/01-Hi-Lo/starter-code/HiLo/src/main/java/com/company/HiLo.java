//package com.company;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class HiLo {
//    public static void main(String[] args) {
//        Random randomGenerator = new Random();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to Hi-Low! Please enter your name.");
//        String name = scanner.nextLine();
//        System.out.println("Hi, " + name + " Ok, here are the rules: The computer will come up with a number between 1 and 100 (inclusive).\n" + "Please guess a number.\n");
//        int comNum = randomGenerator.nextInt(100) + 1;
//        int numGuesses = 0;
//        int userGuess = Integer.parseInt(scanner.nextLine());
//
//        while (comNum != userGuess) {
//            if (comNum == userGuess) {
//                numGuesses++;
////                System.out.println("Congratulations " + name + "! You win!\n" + "It took you " + numGuesses + " guesses to find my number!");
//                System.out.printf("Congratulations %s! You win! It took you %d guesses to find my number!\n", name, numGuesses);
//            } if (comNum > userGuess) {
//                numGuesses++;
//                System.out.printf("Too low! This is guess %d\n", numGuesses);
//                userGuess = Integer.parseInt(scanner.nextLine());
//            } if (comNum < userGuess) {
//                numGuesses++;
//                System.out.printf("Too high! This is guess %d\n", numGuesses);
//                userGuess = Integer.parseInt(scanner.nextLine());
//            }
//        }
//    }
//}

package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hi-Low!");
        System.out.println("Please enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("OK, here are the rules:");
        System.out.println("1.The computer will come up with a number between 1 and 100 (inclusive).");
        System.out.println("2.The user will be prompted to guess the number.");
        System.out.println("3.If you guess the number correctly, you win!");
        Random randomGenerator = new Random();

        int cpuChoice = randomGenerator.nextInt(100) + 1;
//        System.out.println("CPU guess is "+ cpuChoice);

        System.out.println("Please enter your guess:");
        int numGuesses = 0;
        int userChoice = Integer.parseInt(scanner.nextLine());
        if (cpuChoice == userChoice) {
            ++numGuesses;
            System.out.printf("Congratulations, %s! You win! \n", userName);
            System.out.printf("It took you %d guesses to find my number!", numGuesses);
        }
        while (userChoice != cpuChoice) {

            if (userChoice < cpuChoice) {
                ++numGuesses;
                System.out.println("Too low!");
                System.out.println("Number of guesses so far: " + numGuesses);
                System.out.println("Please enter your guess:");

                userChoice = Integer.parseInt(scanner.nextLine());
            } else if (userChoice > cpuChoice) {
                ++numGuesses;
                System.out.println("Too high!");
                System.out.println("Number of guesses so far: " + numGuesses);
                System.out.println("Please enter your guess:");

                userChoice = Integer.parseInt(scanner.nextLine());

            }
        }

    }
}


//    The program displays a message that says, “Welcome to Hi-Low!”
//        The program prompts for the user’s name.
//        The program displays a message that says, “OK, , here are the rules:”
//        Code the game to follow these rules:
//
//        The computer will come up with a number between 1 and 100 (inclusive).
//        The user will be prompted to guess the number.
//        If the user guesses the number correctly, the program displays:
//
//        “Congratulations, [name of user]! You win!”
//        "It took you [number of guesses] guesses to find my number!"
//
//
//        If the user does not guess the number correctly, the program will display “Too low!”
//        if the guess is too low and “Too high!” if the guess is too high, and then will prompt the user for another guess.
//        This goes on until the number is guessed correctly.