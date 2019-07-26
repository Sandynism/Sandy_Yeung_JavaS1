package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        System.out.println("Please enter a number to which you would like to count:");
        String input = scanner.nextLine();
        number = Integer.parseInt(input);

        for (int i = 0; i <= number; i += 2) {
            System.out.println(i);
        }
    }
}
