package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList arrayList = new ArrayList<>();
        boolean found = false;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(50 - 1) + 1);
        }
        System.out.println(arrayList);
        System.out.println("Please enter a value from 1-50");
        int userValue = Integer.parseInt(scanner.nextLine());
        System.out.printf("Value to find: %d%n", userValue);

        for(int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).equals(userValue)) {
                found = true;
                index = i;
            }
        }

        if (found) {
            System.out.printf("%d is in the ArrayList in slot %d.%n", userValue, index);
        } else {
            System.out.printf("%d is not in the ArrayList.%n", userValue);
        }
    }
}

//ArrayList - Where Is It?
//Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50. Display those values on the screen, and then prompt the user for an integer. Search through the ArrayList, and if the item is present, give the slot number where it is located. If the value is not in the ArrayList, display a single message saying so. If the value is present more than once, you may either display the message as many times as necessary, or display a single message giving the last slot number in which it appeared.
//
//ArrayList: [45, 39, 32, 12, 44, 50, 26, 42, 16, 20]
//Value to find: 42
//
//42 is in slot 6.
//
//
//ArrayList: [45, 39, 32, 12, 44, 50, 26, 42, 16, 20]
//Value to find: 43
//
//43 is not in the ArrayList.
//
//
//ArrayList: [24, 30, 31, 24, 32, 33, 34, 24, 35, 36]
//Value to find: 24
//
//    you may display either
//
//24 is in slot 0.
//24 is in slot 3.
//24 is in slot 7.
//
//    or
//
//24 is in slot 7.