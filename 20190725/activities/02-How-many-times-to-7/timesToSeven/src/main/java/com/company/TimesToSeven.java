package com.company;

import java.util.Random;

public class TimesToSeven {
    public static void main(String[] args) {
        Random generator = new Random();
        int randomRolls;
        int totalRolls = 0;
        int numOfSevens = 0;
        int rollsToSeven = 0;

        for(int i= 0; i < 100; i++) {
            randomRolls = generator.nextInt(100) + 1;
            System.out.println(randomRolls);
            totalRolls++;

            if(randomRolls == 7) {
                numOfSevens++;

                if(numOfSevens == 1) {
                    rollsToSeven = totalRolls;
                }
            }
        }
        System.out.printf("There have been %d rolls\n", totalRolls);
        System.out.printf("There have been %d sevens\n", numOfSevens);
        System.out.printf("It took %d guesses to get to seven\n", rollsToSeven);

    }
}

//
//    The purpose of this lab is to learn something about the results of rolling virtual dice.  Here are the requirements:
//
//        The program will "roll" a pair of virtual dice (use the random number generator) 100 times and keep track of the following:
//
//        How many rolls it took to roll the first 7
//        The total number of 7s rolled out of the 100 rolls
//
//
//        This information must be displayed to the user after it has been calculated.