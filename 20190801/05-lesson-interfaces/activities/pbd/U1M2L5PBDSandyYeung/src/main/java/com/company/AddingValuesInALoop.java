package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;

        System.out.println("I will add up the numbers you give me.");
        int userNum = Integer.parseInt(scanner.nextLine());

        while (userNum != 0) {
            total += userNum;
            System.out.printf("The total so far is %d%n", total);
            userNum = Integer.parseInt(scanner.nextLine());
        }
    }
}


//Adding Values in a Loop
//Write a program that gets several integers from the user. Sum up all the integers they give you. Stop looping when they enter a 0. Display the total at the end.
//
//You must use a while loop.
//
//I will add up the numbers you give me.
//Number: 6
//The total so far is 6
//Number: 9
//The total so far is 15
//Number: -3
//The total so far is 12
//Number: 2
//The total so far is 14
//Number: 0
//
//The total is 14.
//
//
//I will add up the numbers you give me.
//Number: 1
//The total so far is 1
//Number: 2
//The total so far is 3
//Number: 3
//The total so far is 6
//Number: 4
//The total so far is 10
//Number: 5
//The total so far is 15
//Number: 0
//
//The total is 15