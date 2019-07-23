package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        //Double the number inputted by the user and then add 5. Print the result to the screen.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me a random number");
        int num1 = Integer.parseInt(scanner.nextLine());

        int numDoubled = num1 + num1;
        int addFive = (numDoubled + 5);

        System.out.println(addFive);
    }
}
