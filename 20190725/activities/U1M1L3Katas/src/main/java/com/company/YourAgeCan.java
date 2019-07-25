package com.company;

import java.util.Scanner;

public class YourAgeCan {
    /*
    Write a program that asks the user's age and then prints out whether that person can:
    Vote (18+)
    Drink alcohol (21+)
    Be president (35+)
    Is eligible for AARP (55+)
    Can retire (65+)
    Is an octogenarian (80-89)
    Is more than a century old (100+)
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your age?");
        int age = scanner.nextInt();


        if ((age >= 18) && (age < 21)) {
            System.out.println("Your age can vote !");
        }
        else if ((age >= 21) && (age < 35)) {
            System.out.println("Your age can drink alcohol and vote ! ");
        }
        else if ((age >= 35) && (age < 55)) {
            System.out.println("Your age can run for president, drink alcohol and vote !");
        }
        else if ((age >= 55) && (age < 65)) {
            System.out.println("Your age can register for aarp, run for president, drink alcohol and vote !");
        }
        else if ((age >= 65) && (age < 80)) {
            System.out.println("Your age can retire, register for aarp, run for president, drink alcohol and vote!");
        }
        else if ((age >= 80) && (age <= 89)) {
            System.out.println("Your age is octogenarian. You could retire, register for aarp, run for president, drink alcohol and vote!");
        }
        else if (age >= 100) {
            System.out.println("What an amazing century! You have been an octogenarian, retired, registered for aarp, could have run for president, drank alcohol and voted.");
        }
    }
}
