package com.company;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pileA = 3;
        int pileB = 3;
        int pileC = 3;
        String userPilePick;
        int userRemoveCount;

        System.out.printf("Welcome to Baby Nim, aka Empty the Piles.%n");
        System.out.printf("Each pile will contain 3 stickers.%n");

        while(pileA>0 || pileB>0 || pileC>0) {
            System.out.printf("A: %d ### B: %d ### C: %d%n", pileA, pileB, pileC);
            System.out.printf("Choose a pile: %n");
            userPilePick = scanner.nextLine();
            System.out.printf("How many do you want to remove?%n");
            userRemoveCount = Integer.parseInt(scanner.nextLine());

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
                System.out.printf("A: %d  B: %d  C: %d%n", pileA, pileB, pileC);
                System.out.printf("You got all the stickers! Awesome job!");
            }
        }

    }
}


//Baby Nim, aka Empty the Piles
//Write a program that starts with three "piles" of 3 counters each. Let the player choose piles and remove counters until all the piles are empty.
//
//Start by placing counters (coins or toothpicks or something) into 3 piles.
//The player picks a pile, then removes one or more counters from that pile. (It's okay to take the whole pile.)
//The player picks a new pile, then removes one or more counters from that pile. (It's okay to pick the same pile as before.)
//Once all piles are empty, the game stops.
//You do not need to check for errors like a wrong pile name, or if someone tries to take more counters from the pile than the pile has.
//
//Sample Output
//Here is an example game, with starting piles of 3 counters.
//
//A: 3	B: 3	C: 3
//
//Choose a pile: A
//How many to remove from pile A: 2
//
//A: 1	B: 3	C: 3
//
//Choose a pile: C
//How many to remove from pile C: 3
//
//A: 1	B: 3	C: 0
//
//Choose a pile: B
//How many to remove from pile B: 1
//
//A: 1	B: 2	C: 0
//
//Choose a pile: A
//How many to remove from pile A: 1
//
//A: 0	B: 2	C: 0
//
//Choose a pile: B
//How many to remove from pile B: 1
//
//A: 0	B: 1	C: 0
//
//Choose a pile: C
//How many to remove from pile C: 2
//
//A: 0	B: 1	C: -2
//
//Choose a pile: B
//How many to remove from pile B: 1
//
//A: 0	B: 0	C: -2
//
//All piles are empty. Good job!


