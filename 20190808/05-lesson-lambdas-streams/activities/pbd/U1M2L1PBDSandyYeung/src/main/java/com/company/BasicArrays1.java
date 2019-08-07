package com.company;

import java.util.ArrayList;

public class BasicArrays1 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        int size = arrayList.size();

        for(int i = 0; i < size; i++) {
            System.out.printf("Slot %d contains a -113%n", i);
        }
    }
}

//	for(int i=0; i<a.length; i++){
//        System.out.println("Slot "+i+" contains a -113");
//Basic ArrayLists 1
//Create an ArrayList that can hold Integers. Add ten copies of the number -113 to the ArrayList. Then display the contents of the ArrayList on the screen.
//
//This time, you must use a loop, both to fill up the ArrayList and to display it.Also, in the condition of your loop, you should not count up to a literal number. Instead you should use the size() of your ArrayList.
//
//Slot 0 contains a -113
//Slot 1 contains a -113
//Slot 2 contains a -113
//Slot 3 contains a -113
//Slot 4 contains a -113
//Slot 5 contains a -113
//Slot 6 contains a -113
//Slot 7 contains a -113
//Slot 8 contains a -113
//Slot 9 contains a -113