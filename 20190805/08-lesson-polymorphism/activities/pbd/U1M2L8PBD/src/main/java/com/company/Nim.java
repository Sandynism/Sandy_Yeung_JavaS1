package com.company;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pileA = 3;
        int pileB = 4;
        int pileC = 5;
        String userPilePick;
        int userRemoveCount;
        int rounds = 0;
        String player1;
        String player2;
        String currentPlayer= "";

        System.out.printf("Welcome to Nim, aka Empty the Piles.%n");
        System.out.printf("Each pile will contain stickers.%n");
        System.out.printf("Player 1, please enter your name: %n");
        player1 = scanner.nextLine();
        System.out.printf("Player 2, please enter your name: %n");
        player2 = scanner.nextLine();

        while(pileA>0 || pileB>0 || pileC>0) {
            if(rounds%2 ==0) {
                currentPlayer= player1;
            } else if(rounds%2 >0) {
                currentPlayer= player2;
            }
            System.out.printf("A: %d ### B: %d ### C: %d%n", pileA, pileB, pileC);
            System.out.printf("%s, Choose a pile: %n", currentPlayer);
            userPilePick = scanner.nextLine();
            System.out.printf("How many do you want to remove?%n");
            userRemoveCount = Integer.parseInt(scanner.nextLine());
            rounds++;

            if(userPilePick.equalsIgnoreCase("A")) {
                pileA = pileA - userRemoveCount;
            }
            if(userPilePick.equalsIgnoreCase("B")) {
                pileB = pileB - userRemoveCount;
            }
            if(userPilePick.equalsIgnoreCase("C")) {
                pileC = pileC - userRemoveCount;
            }
            if(pileA <=0 && pileB <=0 && pileC <=0) {
                if(currentPlayer == player1) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
                System.out.printf("A: %d  B: %d  C: %d%n", pileA, pileB, pileC);
                System.out.printf("You got all the stickers! Awesome job but %s wins because there are no counters left!", currentPlayer);
            }
        }
    }
}


//Nim
//Nim is a strategy game between two players.
//
//Start by placing counters (coins or toothpicks or something) into 3 piles.
//Player #1 picks a pile, then removes one or more counters from that pile. (It's okay to take the whole pile.)
//Player #2 picks a pile, then removes one or more counters from that pile.
//Player #1 plays again. (It's okay to choose a different pile this time.)
//Whichever player is forced to take the last counter is the LOSER.
//Write a program that allows two human players to play Nim against each other. The program should detect when the last counter has been taken and declare a winner.
//
//At first, don't worry about detecting cheating. That is one of the bonus options.
//
//Sample Output
//Here is an example game, with starting piles of 3, 4, and 5 counters.
//
//Player 1, enter your name: Alice
//Player 2, enter your name: Bob
//
//A: 3	B: 4	C: 5
//
//Alice, choose a pile: A
//How many to remove from pile A: 2
//
//A: 1	B: 4	C: 5
//
//Bob, choose a pile: C
//How many to remove from pile C: 3
//
//A: 1	B: 4	C: 2
//
//Alice, choose a pile: B
//How many to remove from pile B: 1
//
//A: 1	B: 3	C: 2
//
//Bob, choose a pile: B
//How many to remove from pile B: 1
//
//A: 1	B: 2	C: 2
//
//Alice, choose a pile: A
//How many to remove from pile A: 1
//
//A: 0	B: 2	C: 2
//
//Bob, choose a pile: B
//How many to remove from pile B: 1
//
//A: 0	B: 1	C: 2
//
//Alice, choose a pile: C
//How many to remove from pile C: 2
//
//A: 0	B: 1	C: 0
//
//Bob, choose a pile: B
//How many to remove from pile B: 1
//
//A: 0	B: 0	C: 0
//
//Alice, there are no counters left, so you WIN!
//Bonus #1 - Cheat Protection
//For +30 bonus points, prevent the users from doing anything bad:
//
//...a game already in progress.
//
//A: 0	B: 1	C: 0
//
//Bob, choose a pile: A
//
//Nice try, Bob. That pile is empty. Choose again: B
//How many to remove from pile B: 0
//
//You must choose at least 1. How many? 1
//
//A: 0	B: 0	C: 0
//And what about this?
//
//A: 1	B: 4	C: 5
//
//Bob, choose a pile: C
//How many to remove from pile C: 8
//
//Pile C doesn't have that many. Try again: 3
//
//A: 1	B: 4	C: 2
//And don't forget this:
//
//A: 1	B: 4	C: 5
//
//Bob, choose a pile: C
//How many to remove from pile C: -2
//
//You must choose at least 1. How many? 3
//
//A: 1	B: 4	C: 2
//Bonus #2 - Dignity
//For +10 bonus points, make your program detect when there is only one counter left and declare the winner one turn earlier.
//
//...a game already in progress.
//
//A: 0	B: 2	C: 2
//
//Bob, choose a pile: B
//How many to remove from pile B: 1
//
//A: 0	B: 1	C: 2
//
//Alice, choose a pile: C
//How many to remove from pile C: 2
//
//A: 0	B: 1	C: 0
//
//Bob, you must take the last remaining counter, so
//you lose. Alice wins!
//Bonus #3 - Fancy Display (Rows)
//For +15 bonus points, visually display the counters in rows instead of just showing a number. You must use loops for this.
//
//A: ***
//B: ****
//C: *****
//
//Alice, choose a pile: A
//How many to remove from pile A: 2
//
//A: *
//B: ****
//C: *****
//
//Bob, choose a pile: C
//How many to remove from pile C: 3
//
//A: *
//B: ****
//C: **
//Bonus #4 - Fancy Display (Columns)
//For +25 bonus points, visually display the counters in columns. You must use a loop for this.
//
//This is quite difficult.
//
//        *
//      * *
//    * * *
//    * * *
//    * * *
//    A B C
//
//Alice, choose a pile: A
//How many to remove from pile A: 2
//
//        *
//      * *
//      * *
//      * *
//    * * *
//    A B C
//
//Bob, choose a pile: C
//How many to remove from pile C: 3
//
//      *
//      *
//      * *
//    * * *
//    A B C
//Bonus #5 - Computer Opponent
//For +50 bonus points, allow one human player to play against a computer opponent. The computer must attempt to win and not break any rules.
//
//It is possible to make a computer player that ALWAYS wins if it goes first. The Wikipedia article for Nim explains the theory.
//
//However, your program does not need to use a winning strategy to earn bonus points: it merely must make only legal moves.