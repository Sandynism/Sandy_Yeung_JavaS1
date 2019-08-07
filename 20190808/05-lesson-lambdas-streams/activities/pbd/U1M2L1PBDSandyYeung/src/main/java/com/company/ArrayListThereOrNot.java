package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ArrayListThereOrNot {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList arrayList = new ArrayList<>();
        boolean found = false;

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
                found = true;
            }
        }

        if(found) {
            System.out.printf("%d is in the ArrayList.%n", userValue);
        }else{
            System.out.printf("%d is not in the ArrayList.%n", userValue);
        }
    }
}

//ArrayList - There or Not?
//Create an ArrayList of Integers, and fill each slot with a different random value from 1-50. Display those values on the screen, and then prompt the user for an integer. Search through the ArrayList, and if the item is present, say so. If the value is not in the ArrayList, display a single message saying so. Just like the previous assignment, if the value is present more than once, you may display the message as many times as necessary.
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
//43 is not in the ArrayList.