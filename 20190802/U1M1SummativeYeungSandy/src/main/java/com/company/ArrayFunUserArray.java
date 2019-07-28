package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayFunUserArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] userIntegers;
        userIntegers = new int[5];

        for (int i = 0; i < userIntegers.length; i++) {
            System.out.println("Enter a number: ");
            userIntegers[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(userIntegers));
    }
}

//This solution must be contained in a Java file called ArrayFunUserArray. Your code must read 5 ints from the user, put them in an array, and print the array elements to the screen.