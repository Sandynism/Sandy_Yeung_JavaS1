package com.company;

import java.util.ArrayList;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList arrayList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(100-1) +1);
        }

        ArrayList secondArrayList = (ArrayList)arrayList.clone();
        arrayList.set(arrayList.size()-1, -7);

        System.out.println("ArrayList 1: " + arrayList);
        System.out.println("ArrayList 2: " + secondArrayList);
    }
}

//Copying ArrayLists
//Write a program that creates an ArrayList of Integers. It should put ten random numbers from 1 to 100 in the ArrayList. It should copy all the elements of that ArrayList into another ArrayList of the same size. Then display the contents of both ArrayLists in any way you like.
//
//Create an ArrayList of Integers
//Fill the ArrayList with ten random numbers (1-100)
//Copy each value from the ArrayList into another ArrayList of the same capacity
//Change the last value in the first ArrayList to a -7
//Display the contents of both ArrayLists
//ArrayList 1: [45, 87, 39, 32, 93, 86, 12, 44, 75, -7]
//ArrayList 2: [45, 87, 39, 32, 93, 86, 12, 44, 75, 50]