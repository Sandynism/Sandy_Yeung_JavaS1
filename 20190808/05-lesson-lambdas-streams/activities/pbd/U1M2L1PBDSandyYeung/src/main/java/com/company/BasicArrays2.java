package com.company;

import java.util.ArrayList;
import java.util.Random;

public class BasicArrays2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList arrayList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(100-1) +1);
        }
        System.out.println("ArrayList: " + arrayList);
    }
}

//Basic ArrayLists 2
//Create an ArrayList of Integers. Fill up the list with ten random numbers, each from 1 to 100. Then display the contents of the ArrayList on the screen.
//
//You must use a loop to fill up the list. However, you may display it the easy way (no loop needed) like so:
//
//System.out.println( "ArrayList: " + whateverYourArrayListVariableIsCalled );
//ArrayList: [45, 87, 39, 32, 93, 86, 12, 44, 75, 50]