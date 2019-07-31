package com.company;

import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Want to find out which integers make a right triangle? Enter a number:");
        int userNum1 = Integer.parseInt(scanner.nextLine());
        System.out.printf("Side 1: %d%n", userNum1);
        System.out.printf("Enter a second number:%n");
        int userNum2 = Integer.parseInt(scanner.nextLine());
        System.out.printf("Side 2: %d%n", userNum2);

        while (userNum2 < userNum1) {
            System.out.printf("%d is smaller than %d. Try again. %n", userNum2, userNum1);
            userNum2 = Integer.parseInt(scanner.nextLine());
            System.out.printf("Side 2: %d%n", userNum2);
        }
        System.out.printf("Enter a third number:%n");
        int userNum3 = Integer.parseInt(scanner.nextLine());
        System.out.printf("Side 3: %d%n", userNum3);
        while (userNum3 < userNum2) {
            System.out.printf("%d is smaller than %d. Try again. %n", userNum3, userNum2);
            userNum3 = Integer.parseInt(scanner.nextLine());
            System.out.printf("Side 3: %d%n", userNum3);
        }

        if (userNum3 == userNum2 || userNum2 == userNum1) {
            System.out.printf("Your three sides are: %d, %d, %d.%nNO! These sides do not make a right triangle!", userNum1, userNum2, userNum3);
        }
        if (userNum3 > userNum2 && userNum2 > userNum1) {
            System.out.printf("Your three sides are: %d, %d, %d.%nThese sides DO make a right triangle! Yippy-skippy!", userNum1, userNum2, userNum3);
        }
    }
}

//Right Triangle Checker
//Write a program to allow the user to enter three integers. You must use do-while or while loops to enforce that these integers are in ascending order, though duplicate numbers are allowed.
//
//Tell the user whether or not these integers would represent the sides of a right triangle.
//
//Enter three integers:
//Side 1: 4
//Side 2: 3
//3 is smaller than 4.  Try again.
//Side 2: -9
//-9 is smaller than 4.  Try again.
//Side 2: 5
//Side 3: 1
//1 is smaller than 5.  Try again.
//Side 3: 5
//
//Your three sides are 4 5 5
//NO!  These sides do not make a right triangle!
//
//
//Enter three integers:
//Side 1: 6
//Side 2: 8
//Side 3: 10
//
//Your three sides are 6 8 10
//These sides *do* make a right triangle.  Yippy-skippy!