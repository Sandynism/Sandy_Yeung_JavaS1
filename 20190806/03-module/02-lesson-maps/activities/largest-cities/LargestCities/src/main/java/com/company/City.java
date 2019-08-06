package com.company;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class City {
    String name;
    int population;
    public static Map<String, City> mapCities = new HashMap<>();

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public static void main(String[] args) {


        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621  );
        City desMoines = new City("Des Moines", 217521 );
        City atlanta = new City("Atlanta",486213  );

        mapCities.put("New York", newYork);
        mapCities.put("California", losAngeles);
        mapCities.put("Illinois", chicago);
        mapCities.put("Colorado", denver);
        mapCities.put("Iowa", desMoines);
        mapCities.put("Georgia", atlanta);

        printStateAndCity();
        printUserPopulation();
    }

    public static void printStateAndCity() {
        for (Map.Entry<String, City> entry : mapCities.entrySet())
            System.out.println("State: " + entry.getKey() + ", City: " + entry.getValue().name + ", Population: " + entry.getValue().population);
    }

    public static void printUserPopulation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a population over 217521.");
        int userPopulation = Integer.parseInt(scanner.nextLine());
        for (Map.Entry<String, City> entry : mapCities.entrySet())
            if (entry.getValue().population >= userPopulation) {
                System.out.println("State: " + entry.getKey());
            }
    }
}

//Your program must do the following:
//
//
//Create a class called City with the following properties:
//a. name
//b. population
//
//
//Create City variables to hold the below data.
// |       City      |    Population     |
// |-----------------|-------------------|
// | New York        |      8654321      |
// | Los Angeles     |      4563218      |
// | Chicago         |      2716520      |
// | Denver          |       704621      |
// | Des Moines      |       217521      |
// | Atlanta         |       486213      |
//
//
//Create a Map that holds the names of states and their corresponding City objects (State name is the key, City object is the value)
//
//
//Prints the name and population for each City along with its corresponding state name to the screen
//
//
//Prints the states with cities that have a population over a given value (this value is typed in by the user of the program) to the screen
//
//
//Hint: You will have to add code to ask the user for a minimum population. Once you have this value, go through each state/city pair as you did for #4 above but only print the information for cities that have a population above the limit