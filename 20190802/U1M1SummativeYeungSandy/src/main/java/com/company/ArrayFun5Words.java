package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArray;
        wordsArray = new String[5];

        for(int i = 0; i < wordsArray.length; i++) {
            System.out.println("Please enter a word");
            wordsArray[i] = scanner.nextLine();
        }
        System.out.println(Arrays.toString(wordsArray));
    }
}

//This solution must be contained in a Java file called ArrayFun5Words. Your code must get 5 words from the user, put them in an array, and print the array elements to the screen.