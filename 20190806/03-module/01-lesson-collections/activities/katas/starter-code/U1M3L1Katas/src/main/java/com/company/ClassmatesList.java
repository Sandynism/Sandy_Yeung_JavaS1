package com.company;

import java.util.List;
import java.util.LinkedList;

public class ClassmatesList {

    List classmatesList = new LinkedList<>();


    public void add(Classmate classmate) {
        this.classmatesList.add(classmate);
    }

    public Classmate get(int index) {
        return (Classmate) this.classmatesList.get(index);
    }

    public List getAll(){
        return classmatesList;
    }
}

//package com.company;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ClassmatesList {
//
//    private static List<Classmate> classmatesList = new ArrayList<>();
//
//    public static void add(Classmate classmate) {
//        classmatesList.add(classmate);
//    }
//
//    public static Classmate get(int index) {
//        return classmatesList.get(index);
//    }
//
//    public static List<Classmate> getAll() {
//
//        return classmatesList;
//    }
//}

//Implement the following public methods in the ClassmatesList class:
//
//
//add which takes in a new Classmate and adds it to the list of classmates.
//
//get which takes in an int and returns the classmate at that index.
//
//getAll which returns the entire list.

