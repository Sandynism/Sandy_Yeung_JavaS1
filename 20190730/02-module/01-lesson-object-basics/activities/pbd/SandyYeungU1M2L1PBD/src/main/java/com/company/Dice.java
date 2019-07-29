package com.company;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int roll1 = randomGenerator.nextInt((6-1) +1) + 1;
        int roll2 = randomGenerator.nextInt((6-1) +1) +1;
        int total = roll1 + roll2;

        System.out.println("HERE COMES THE DICE!");
        System.out.printf("Roll #1: %d%n", roll1);
        System.out.printf("Roll #2: %d%n", roll2);
        System.out.println("The total is " + total + "!");
    }
}

//Write a program that simulates a dice roll by picking a random number from 1-6 and then picking a second random number from 1-6. Add the two values together, and display the total.
//
//HERE COMES THE DICE!
//
//Roll #1: 3
//Roll #2: 5
//The total is 8!
//
//
//HERE COMES THE DICE!
//
//Roll #1: 4
//Roll #2: 2
//The total is 6!