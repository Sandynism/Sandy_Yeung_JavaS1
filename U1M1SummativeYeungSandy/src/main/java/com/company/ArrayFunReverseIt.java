package com.company;

import java.util.Arrays;

public class ArrayFunReverseIt {

    public static int[] reverse(int[] originalArray) {
        int[] newArray;
        newArray = new int[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[originalArray.length - 1 - i];
        }
        System.out.println("Original Array: " + Arrays.toString(originalArray) + " New Array: " + Arrays.toString(newArray));
        return newArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};

        reverse(originalArray);
    }
}

//This solution must be contained in a Java file called ArrayFunReverseIt. Your code must declare the following array [1, 2, 3, 4, 5], create another array of equal length, and fill that array with values from the original array but in reverse order. Finally, your code must print the contents of both arrays to the screen.