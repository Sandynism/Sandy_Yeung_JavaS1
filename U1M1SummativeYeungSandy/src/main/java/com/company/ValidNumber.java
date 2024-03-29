package com.company;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 10.");
        int number = Integer.parseInt(scanner.nextLine());

        if (number < 1 || number > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
        } else if (number > 1 && number < 10) {
            System.out.println(number);
        }
    }
}

//This program prompts the user for a number between 1 and 10 and keeps asking until the entered number is in range. Your solution must be in a Java file called ValidNumber.
//The program must do the following:
//
//Prompt the user to enter a number between 1 and 10.
//If the user enters a number less than 1 or greater than 10, display the following error message and prompt the user for another entry: "You must enter a number between 1 and 10, please try again."
//When the user enters a valid number, print the number to the screen and exit.