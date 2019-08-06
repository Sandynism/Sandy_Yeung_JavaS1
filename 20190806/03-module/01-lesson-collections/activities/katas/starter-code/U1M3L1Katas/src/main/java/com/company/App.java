package com.company;

import java.util.ArrayList;

public class App {

    public static int total(ArrayList<Integer> numbers) {

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }


    public static int totalEven(ArrayList<Integer> numbers) {

        int sum = 0;
        int size = numbers.size();
        for (int i = 0; i < size; i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static ArrayList<String> swapFirstAndLast(ArrayList<String> strings) {

        String temp = strings.get(0);
        int size = strings.size();
        strings.set(0, strings.get(size - 1));
        strings.set(size - 1, temp);

        return strings;
    }


    public static ArrayList<Integer> reverse(ArrayList<Integer> numbers) {
        // int[] reversed = new int[numbers.length];
        //        for(int i = 0; i < numbers.size(); i++) {
//            // length - (i + 1) is the n-th to last element
//            // so when i = 0, it would be the last element
//            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
//            reversed[i] = numbers[ numbers.size() - (i + 1) ];
//        }
        ArrayList<Integer> reversed = new ArrayList<>(numbers.size());
//        Collections.reverse(reversed);
        for (int i = numbers.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            reversed.add(numbers.get(i));
        }
        // Return the reversed arraylist
        return reversed;
    }


    public static ArrayList<Integer> lessThanFive(ArrayList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }
        if ( numLessThanFive == 0 ) {
            return null;
        }

        ArrayList<Integer> lessThan = new ArrayList<>(numLessThanFive);
        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            }
        }
        return lessThan;
    }

//    //challenge
//    public static int[][] splitAtFive(ArrayList<Integer> numbers) {
//        int numLessThanFive = 0;
//        int numMoreThanFive = 0;
//
//        for(int num : numbers) {
//            if ( num < 5 ) {
//                numLessThanFive++;
//            } else {
//                numMoreThanFive++;
//            }
//        }
//
//        int[] lessThan = new int[numLessThanFive];
//        int[] moreThan = new int[numMoreThanFive];
//
//
//        for(int num : numbers) {
//
//            // subtracting numLessThanFive from length then decrementing numLessThanFive
//            // allows us to go from 0 to length - 1 in order without additional variables
//            // same with numMoreThanFive
//            if ( num < 5 ) {
//                lessThan[lessThan.length - numLessThanFive] = num;
//                numLessThanFive--;
//            } else {
//                moreThan[moreThan.length - numMoreThanFive] = num;
//                numMoreThanFive--;
//            }
//        }
//
//        return new int[][] { lessThan, moreThan };
//    }
//
//    // Challenge
//    public static String[][] evensAndOdds(ArrayList<String> strings) {
//
//        //leveraging integer division
//        String[] odds = new String[ strings.length/2 ];
//
//        // Set evens to null for reassignment below
//        String[] evens = null;
//
//        // again leveraging integer division
//        // if it's already of even length, we're good
//        // but if it's of odd length, there's one more even index than odd
//        if (strings.length % 2 == 0) {
//            evens = new String[ strings.length/2];
//        } else {
//            evens = new String[ strings.length/2 + 1];
//        }
//
//        for(int i = 0; i < strings.length; i++) {
//            int currIndex = i/2;
//            if( i % 2 == 0 ) {
//                evens[currIndex] = strings[i];
//            } else {
//                odds[currIndex] = strings[i];
//            }
//        }
//
//        return new String[][] { evens, odds };
//    }
}


//For all of the below, remember to program to the interface rather than to the concrete class (i.e., declare your variables as List instead of ArrayList).
//
//        Refactor the following array methods found in App to use an ArrayList instead:
//
//        total
//        totalEven
//        swapFirstAndLast
//        reverse
//        lessThanFive
//
//        splitAtFive Challenge
//
//
//        evensAndOdds Challenge
//
//
//
//        Create a new class called LinkedListApp and refactor the above activities to implement a LinkedList instead of an ArrayList.
//        Complete the following steps to create a List to hold information about your classmates.
//
//        Create a Classmate class, which has the properties name and hairColor, along with the associated getters/setters.
//        Create another class called ClassmatesList to hold Classmate objects.
//
//        it should have a single private property which is an ArrayList of Classmate objects.
//        do not create getters and setters for this list.
//
//
//        Implement the following public methods in the ClassmatesList class:
//
//
//        add which takes in a new Classmate and adds it to the list of classmates.
//
//        get which takes in an int and returns the classmate at that index.
//
//        getAll which returns the entire list.
//
//
//
//
//        Create a new class called SetIterator and create a public method called printSet which does the following:
//
//        returns nothing.
//        takes in five integers as its arguments.
//        adds those integers into a new HashSet.
//        Uses an Iterator to print all members of the HashSet.