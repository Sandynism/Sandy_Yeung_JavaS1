package com.company;

import java.util.ArrayList;
import java.util.Random;

public class largestNumArraySlot {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList <Integer> arrayList = new ArrayList<>();
        int max = 0;
        int slot = 0;

        for(int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(100-1) + 1);
        }
        System.out.println("ArrayList: " + arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) > max) {
                max = arrayList.get(i);
                slot = i;
            }
        }
        System.out.println("The largest value is " + max + ", which is in slot " + slot);
        //the slots starting from 0 is extremely silly but for this assignment, it asks us to do that.
    }
}

//Locating the Largest Value in an ArrayList
//Write a program that creates an ArrayList of Integers. Fill the ArrayList with random numbers from 1 to 100. Display the values in the ArrayList on the screen. Then use a linear search to find the largest value in the ArrayList, and display that value and its slot number.
//
//ArrayList: [45, 87, 39, 32, 93, 86, 12, 44, 75, 50]
//
//The largest value is 93, which is in slot 4