package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class FindingValueArrayList {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(50 - 1) + 1);
        }
        System.out.println(arrayList);
        System.out.println("Please enter a value from 1-50");
        int userValue = Integer.parseInt(scanner.nextLine());
        System.out.printf("Value to find: %d%n", userValue);

        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals(userValue)) {
                System.out.printf("%d is in the ArrayList.%n", userValue);
            }
        }
    }
}

//Finding a Value in an ArrayList
//Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50. Display those values on the screen, and then prompt the user for an integer. Search through the ArrayList, and if the item is present, say so. It is not necessary to display anything if the value was not found. If the item is in the ArrayList multiple times, it's okay if the program prints the message more than once.
//
//ArrayList: [45, 39, 32, 12, 44, 50, 26, 42, 16, 20]
//Value to find: 42
//
//42 is in the ArrayList.
//
//
//ArrayList: [45, 39, 32, 12, 44, 50, 26, 42, 16, 20]
//Value to find: 43
//
//
//
//ArrayList: [24, 30, 31, 24, 32, 33, 34, 24, 35, 36]
//Value to find: 24
//
//24 is in the ArrayList.
//24 is in the ArrayList.
//24 is in the ArrayList.