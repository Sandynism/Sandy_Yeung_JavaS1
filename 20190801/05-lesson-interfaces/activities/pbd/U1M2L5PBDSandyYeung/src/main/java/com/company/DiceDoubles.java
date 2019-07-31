package com.company;

import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int roll1 = randomGenerator.nextInt((6 - 1) + 1) + 1;
        int roll2 = randomGenerator.nextInt((6 - 1) + 1) + 1;
        int total;


        while(roll1 != roll2) {
            roll1 = randomGenerator.nextInt((6 - 1) + 1) + 1;
            roll2 = randomGenerator.nextInt((6 - 1) + 1) + 1;
            total = roll1 + roll2;
            System.out.println("HERE COMES THE DICE!");
            System.out.printf("Roll #1: %d%n", roll1);
            System.out.printf("Roll #2: %d%n", roll2);
            System.out.println("The total is " + total + "!");
        }
        if (roll1 == roll2) {
            System.out.println("You win!");
        }
    }
}

//Dice Doubles
//Modify your dice game from last time so that it keeps rolling until they get doubles (the same number on both dice).
//
//Notice that since there's no user input, this will happen very quickly (all the rolls will happen one right after the other).
//
//HERE COMES THE DICE!
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