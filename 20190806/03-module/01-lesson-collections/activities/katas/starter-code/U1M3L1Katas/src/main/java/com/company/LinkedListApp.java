package com.company;

import java.util.LinkedList;

public class LinkedListApp {
    public static int total(LinkedList<Integer> numbers) {

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }


    public static int totalEven(LinkedList<Integer> numbers) {

        int sum = 0;
        int size = numbers.size();
        for (int i = 0; i < size; i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static LinkedList<String> swapFirstAndLast(LinkedList<String> strings) {

        String temp = strings.get(0);
        int size = strings.size();
        strings.set(0, strings.get(size - 1));
        strings.set(size - 1, temp);

        return strings;
    }


    public static LinkedList<Integer> reverse(LinkedList<Integer> numbers) {

        LinkedList<Integer> reversed = new LinkedList<Integer>();
//        Collections.reverse(reversed);
        for (int i = numbers.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            reversed.add(numbers.get(i));
        }
        // Return the reversed LinkedList
        return reversed;
    }



    public static LinkedList<Integer> lessThanFive(LinkedList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }
        if ( numLessThanFive == 0 ) {
            return null;
        }

        LinkedList<Integer> lessThan = new LinkedList<Integer>();
        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            }
        }
        return lessThan;
    }
}

//Create a new class called LinkedListApp and refactor the above activities to implement a LinkedList instead of an ArrayList.
//Complete the following steps to create a List to hold information about your classmates.
//
//Create a Classmate class, which has the properties name and hairColor, along with the associated getters/setters.
//Create another class called ClassmatesList to hold Classmate objects.
//
//it should have a single private property which is an ArrayList of Classmate objects.
//do not create getters and setters for this list.
//
//
//Implement the following public methods in the ClassmatesList class:
//
//
//add which takes in a new Classmate and adds it to the list of classmates.
//
//get which takes in an int and returns the classmate at that index.
//
//getAll which returns the entire list.
//
//
//
//
//Create a new class called SetIterator and create a public method called printSet which does the following:
//
//returns nothing.
//takes in five integers as its arguments.
//adds those integers into a new HashSet.
//Uses an Iterator to print all members of the HashSet.