package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

    }

    public void printKeys(Map<String, String> map) {
//        map.forEach((k,v) -> System.out.println(k));
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println(entry.getKey());
    }

    public void printValues(Map<String, String> map) {
//        map.forEach((k,v) -> System.out.println(v));
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    public void printKeysAndValues(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    public Map mapFun(Map<String, Integer> map) {
        map.put("Ford Explorer", 2012);
        map.put("Smart Fortwo", 2013);
        map.remove("Jeep Wrangler");
        return map;
    }

    public Map listCars(ArrayList<Car> cars) {
        ArrayList<Car> toyotaList = new ArrayList();
        ArrayList<Car> fordList = new ArrayList();
        ArrayList<Car> hondaList = new ArrayList();

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getMake() == "Toyota") {
                toyotaList.add(cars.get(i));
            } else if (cars.get(i).getMake() == "Ford") {
                fordList.add(cars.get(i));
            } else if (cars.get(i).getMake() == "Honda") {
                hondaList.add(cars.get(i));
            }
        }

        Map<String, ArrayList<Car>> carList = new HashMap<>();

        carList.put("Toyota", toyotaList);
        carList.put("Ford", fordList);
        carList.put("Honda", hondaList);
        return carList;
    }
}


//Create a method called listCars, which takes in a List of Car objects and complete the following:
//
//Create a List called toyotaList to hold all the Car variables with "Toyota" as the make and add them to the List.
//Create a List called fordList to hold all the Car variables with "Ford" as the make and add them to the List.
//Create a List called hondaList to hold all the Car variables with "Honda" as the make and add them to the List.
//Store all 3 List in a Map with the make as the key.
//Return the Map.
//
//
//
//Hint: Your key will be a String. What will your value be?

//Create a method called printKeys which takes in a Map with String keys and String values and iterates through and prints out all keys in the Map.
//Create a method called printValues which takes in a Map with String keys and String values and iterates through and prints out allvalues in the Map.
//Create a method called printKeysAndValues which takes in a Map with String keys and String values iterates through the Entry Set of the Map and print both the keys and values in the Map in this format: key: value.
//Create a method called mapFun which does the following:
//
//
//Takes in a Map with String keys and integer values
//
//
//Returns a Map with String keys and integer values
//
//
//Assume the Map will always contain at least these entries:
//
//
//
//Key
//Value
//
//
//
//
//Toyota Camry
//2012
//
//
//Chevy Camaro
//1969
//
//
//Hyundai Genesis
//2015
//
//
//Jeep Wrangler
//2003
//
//
//Honda Civic
//2018
//
//
//Toyota Supra
//1995
//
//
//Pontiac GTO
//1964
//
//
//
//
//
//Add two new entries to the Map - a 2012 Ford Explorer and a 2013 Smart Fortwo.
//
//
//Remove the Jeep Wrangler from the Map
//
//
//Return the Map
//
//
//
