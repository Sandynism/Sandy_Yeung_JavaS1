package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {
    public void printSet(int a, int b, int c, int d, int e) {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(a);
        integerSet.add(b);
        integerSet.add(c);
        integerSet.add(d);
        integerSet.add(e);

        Iterator<Integer> iteratorSet = integerSet.iterator();
        while (iteratorSet.hasNext()) {
            Integer member = iteratorSet.next();
            System.out.println(member);
        }
    }
}

//Create a new class called SetIterator and create a public method called printSet which does the following:
//
//returns nothing.
//takes in five integers as its arguments.
//adds those integers into a new HashSet.
//Uses an Iterator to print all members of the HashSet.