package com.company;

import java.util.Scanner;

public class EvenOrOdd {
    //Write a program that gets user input (an integer) and prints whether it's even or odd.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number so I can tell you if its even or odd.");
        int userInput = scanner.nextInt();

        if(userInput%2 == 0) {
            System.out.printf("Awesome! %d is an even number!", userInput);
        } else {
            System.out.printf("Cool! %d is an odd number!", userInput);
        }
    }
}
