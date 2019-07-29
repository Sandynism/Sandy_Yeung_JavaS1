package com.company;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you ready for a quiz?");
        String response = scanner.nextLine();
        int counter = 0;

        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.println("Okay, here it comes!\n");

            System.out.println("Q1: What is the name of the instructor for the Java bootcamp?\n");
            System.out.println("1) Sal, 2) Salvo, 3) Nateyana");
            int response1 = Integer.parseInt(scanner.nextLine());
            if (response1 == 1) {
                counter++;
                System.out.println("That is correct!");
            } else {
                System.out.println("That is incorrect");
            }

            System.out.println("Q1: What are the names of the TA's for the Java bootcamp?\n");
            System.out.println("1) Sal and Bob, 2) Salvo and Nateyana, 3) Nate and Sandy");
            int response2 = Integer.parseInt(scanner.nextLine());
            if (response2 == 2) {
                counter++;
                System.out.println("That is correct!");
            } else {
                System.out.println("That is incorrect");
            }

            System.out.println("Q1: When is this assignment due?\n");
            System.out.println("1) August 3, 2020, 2) July 30, 2019, 3) July 29, 2019");
            int response3 = Integer.parseInt(scanner.nextLine());
            if (response3 == 2) {
                counter++;
                System.out.println("That is correct!");
            } else {
                System.out.println("That is incorrect");
            }
        } else {
            return;
        }
        System.out.printf("Overall, you got %d correct!%n", counter);
        System.out.println("Thanks for playing! Have a splendid day!");

    }
}

//Write an interactive quiz. It should ask the user three multiple-choice or true/false questions about something. It must keep track of how many they get wrong, and print out a "score" at the end.
//Are you ready for a quiz?  N
//Okay, here it comes!
//
//Q1) What is the capital of Alaska?
//	1) Melbourne
//	2) Anchorage
//	3) Juneau
//
//> 3
//
//That's right!
//
//Q2) Can you store the value "cat" in a variable of type int?
//	1) yes
//	2) no
//
//> 1
//
//Sorry, "cat" is a string. ints can only store numbers.
//
//Q3) What is the result of 9+6/3?
//	1) 5
//	2) 11
//	3) 15/3
//
//> 2
//
//That's correct!
//
//
//Overall, you got 2 out of 3 correct.
//Thanks for playing!