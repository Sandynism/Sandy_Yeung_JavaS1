package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class largestNumArray {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList <Integer> arrayList = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(100-1) + 1);
        }
        System.out.println("Unsorted: " + arrayList);

//        Collections.sort(arrayList);
//        System.out.println("Sorted: " + arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) > max) {
                max = arrayList.get(i);
            }
        }
        System.out.println("The largest value is " + max);

    }
}

//Getting the Largest Value in an ArrayList
//Write a program that creates an ArrayList which can hold Integers. Fill the ArrayList with random numbers from 1 to 100. Display the values in the ArrayList on the screen. Then use a linear search to find the largest value in the ArrayList, and display that value.
//
//ArrayList: [45, 87, 39, 32, 93, 86, 12, 44, 75, 50]
//
//The largest value is 93