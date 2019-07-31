package com.company;

import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double userNum;

        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number:");
        userNum = Double.parseDouble(scanner.nextLine());

        while(true) {
            if (userNum < 0) {
                System.out.println("You can't take the square root of a negative number, silly.");
                System.out.println("Enter another number:");
                userNum = Double.parseDouble(scanner.nextLine());
            } else {
                double squareNum = Math.sqrt(userNum);
                System.out.printf("The square root of %f is %f.%n", userNum, squareNum);
                break;
            }
        }
    }
}

//Safe Square Root
//Write a program to take the square root of a number typed in by the user. Your program should use a loop to ensure that the number they typed in is positive. If the number is negative, you should print out some sort of warning and make them type it in again.
//
//Note that it is possible to do this program with either a while loop or a do-while loop. (Though personally, I think this one is easier with a while loop.)
//
//You can get the square root of a number n with Math.sqrt(n). Make sure you don't do this until the loop is done and you know for sure you've got a positive number.
//
//SQUARE ROOT!
//Enter a number: 9
//The square root of 9 is 3.0.
//
//
//SQUARE ROOT!
//Enter a number: 2
//The square root of 2 is 1.4142135623730951.
//
//
//SQUARE ROOT!
//Enter a number: -9
//You can't take the square root of a negative number, silly.
//Try again: -10
//You can't take the square root of a negative number, silly.
//Try again: 10
//The square root of 10 is 3.1622776601683795.