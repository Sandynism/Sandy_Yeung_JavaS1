package com.company;

import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int playerVal1 = randomGenerator.nextInt(10 - 1) + 1;
        int playerVal2 = randomGenerator.nextInt(10 - 1) + 1;
        int playerTotal = playerVal1 + playerVal2;
        int dealerVal1 = randomGenerator.nextInt(10 - 1) + 1;
        int dealerVal2 = randomGenerator.nextInt(10 - 1) + 1;
        int dealerTotal = dealerVal1 + dealerVal2;

        System.out.printf("Let's play a game of baby blackjack!%n");
        System.out.printf("You drew %d and %d.%n", playerVal1, playerVal2);
        System.out.printf("Your total is %d.%n", playerTotal);
        System.out.printf("You drew %d and %d.%n", dealerVal1, dealerVal2);
        System.out.printf("Dealer's total is %d.%n", dealerTotal);

        if (playerTotal > dealerTotal) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("DEALER WINS!");
        }
    }
}

//Baby Blackjack
//Write a program that allows a human user to play a single hand of "blackjack" against a dealer.
//
//Pick two values from 1-10 for the player. These are the player's "cards".
//Pick two more values from 1-10 for the dealer.
//Whoever has the highest total is the winner.
//There is no betting, no busting, and no hitting. Save that for real blackjack.
//Baby Blackjack!
//
//You drew 6 and 5.
//Your total is 11.
//
//The dealer has 7 and 3.
//Dealer's total is 10.
//
//YOU WIN!