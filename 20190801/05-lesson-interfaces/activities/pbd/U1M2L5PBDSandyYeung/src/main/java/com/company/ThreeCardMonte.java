package com.company;

import java.util.Scanner;
import java.util.Random;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userGuess;

        System.out.println("Want to play a card game? I have three cards, two Jacks and an Ace. Which card is the ace?%n");
        System.out.printf("## ## ##%n## ## ##%n1  2  3%n");
        int aceCard = random.nextInt((3-1) +1) +1;
        userGuess = Integer.parseInt(scanner.nextLine());

        if(aceCard == userGuess) {
            System.out.println("Gosh darnit. I was supposed to be a better trickster...");
            switch (aceCard) {
                case 1:
                    System.out.printf("AA ## ##%nAA ## ##%n1  2  3");
                    break;
                case 2:
                    System.out.printf("## AA ##%n## AA ##%n1  2  3");
                    break;
                case 3:
                    System.out.printf("## ## AA%n## ## AA%n1  2  3");
                    break;
            }
        }
        else {
            System.out.printf("WooHooHoo! I got you! The ace card was %d.%n", aceCard);
            switch (aceCard) {
                case 1:
                    System.out.printf("AA ## ##%nAA ## ##%n1  2  3");
                    break;
                case 2:
                    System.out.printf("## AA ##%n## AA ##%n1  2  3");
                    break;
                case 3:
                    System.out.printf("## ## AA%n## ## AA%n1  2  3");
                    break;
            }
        }
    }
}

//Three Card Monte
//This is the original "ball and cups" game where you try to find out which cup has the ball under it. You may play with three cups and a ball, three cards (two jacks and an ace), or three doors and a car. Basically, randomly select a cup to hide the "ball". Let the player guess which cup hides the ball. The player wins if they guess correctly.
//
//You slide up to Fast Eddie's card table and plop down your cash.
//He glances at you out of the corner of his eye and starts shuffling.
//He lays down three cards.
//
//Which one is the ace?
//
//	##  ##  ##
//	##  ##  ##
//	1   2   3
//
//> 2
//
//Ha! Fast Eddie wins again! The ace was card number 3.
//
//	##  ##  AA
//	##  ##  AA
//	1   2   3
//
//(Note that this is basically just a number-guessing game with fancy graphics.)
//
//You slide up to Fast Eddie's card table and plop down your cash.
//He glances at you out of the corner of his eye and starts shuffling.
//He lays down three cards.
//
//Which one is the ace?
//
//	##  ##  ##
//	##  ##  ##
//	1   2   3
//
//> 2
//
//You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.
//
//	##  AA  ##
//	##  AA  ##
//	1   2   3