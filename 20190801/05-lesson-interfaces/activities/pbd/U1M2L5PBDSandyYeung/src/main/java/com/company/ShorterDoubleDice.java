package com.company;

import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int roll1 = randomGenerator.nextInt((6 - 1) + 1) + 1;
        int roll2 = randomGenerator.nextInt((6 - 1) + 1) + 1;
        int total;


        do {
            roll1 = randomGenerator.nextInt((6 - 1) + 1) + 1;
            roll2 = randomGenerator.nextInt((6 - 1) + 1) + 1;
            total = roll1 + roll2;
            System.out.println("HERE COMES THE DICE!");
            System.out.printf("Roll #1: %d%n", roll1);
            System.out.printf("Roll #2: %d%n", roll2);
            System.out.println("The total is " + total + "!");
        }
        while (roll1 != roll2);
    }
}


//Shorter Double Dice
//Redo the Dice Doubles assignment (the dice program with a loop) so that it uses a do-while loop instead of a while loop. Otherwise it should behave exactly the same.
//
//If you do this correctly, there should be less code in this version.
//
//HERE COME THE DICE!
//
//Roll #1: 3
//Roll #2: 5
//The total is 8!
//
//Roll #1: 6
//Roll #2: 1
//The total is 7!
//
//Roll #1: 2
//Roll #2: 5
//The total is 7!
//
//Roll #1: 1
//Roll #2: 1
//The total is 2!