package com.company;

import java.util.Random;
import java.util.ArrayList;

public class FortuneCookie {

    public static void randomFortune() {
        Random randomGenerator = new Random();
        ArrayList lottoNumbers = new ArrayList();

        String[] fortunesArray = {"You will get an A+ on your next assignment", "No snowflake in an avalanche ever felt responsible.", "About time I got out of that cookie.", "The brighter you shine, the more stunning you are.", "It is a great day to be alive!"};
        int index;
        int randomNumber;
        String selectedFortune = "";

        for (int i = 0; i < 1; i++) {
            index = randomGenerator.nextInt(fortunesArray.length);
            selectedFortune = fortunesArray[index];
        }

        for (int i = 0; i < 6; i++) {
            randomNumber = randomGenerator.nextInt(54) + 1;
            lottoNumbers.add(randomNumber);
        }

        System.out.println(selectedFortune);
        System.out.println(lottoNumbers);

    }

    public static void main(String[] args) {
        randomFortune();
    }
}

//Write a program that simulates a random fortune from a fortune cookie. You must have at least six fortunes.
//
//For bonus points, also add randomly-chosen lotto numbers to the fortune. In Texas, the lotto chooses 6 numbers, each from 1-54.
//
//Fortune cookie says: "You will find happiness with a new love."
//Bonus output:
//
//Fortune cookie says: "Stick with your wife."
//    13 - 44 - 19 - 37 - 29 - 17