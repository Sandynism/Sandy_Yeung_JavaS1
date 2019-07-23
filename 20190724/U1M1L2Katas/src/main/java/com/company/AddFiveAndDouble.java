package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        //Add 5 to the number inputted by the user and then double it. Print the result to the screen.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me a random number");
        int num1 = Integer.parseInt(scanner.nextLine());

        int addFive = (num1 + 5);
        int numDoubled = addFive + addFive;
        System.out.println(numDoubled);
    }
}
