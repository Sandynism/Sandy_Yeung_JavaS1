package com.company;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Set up the scanner and variables
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        String stringIn;
        int min;
        int max;
        int sum = 0;
        double avg;

        // Read in 10 ints
        for (int i = 0; i < numbers.length; i++) {

            System.out.println("Please enter a number:");
            stringIn = scanner.nextLine();
            numbers[i] = Integer.parseInt(stringIn);
        }

        // Calculate min
        min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        // Calculate max
        max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Calculate average
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        avg = sum/(double)numbers.length;

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }

}

//Minimum value: 1
//Maximum value: 10
//Sum: 55
//Average: 5.5

//Load the project MinMaxAvg.
//Set breakpoints at Line 15, 47, and 52.
//Run the program (remember to switch over to the Console pane when debugging because the program will ask you for input).
//The program will ask you to enter 10 numbers.  Enter 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.
//Write down all the variables that are visible and their associated values when you hit each breakpoint.