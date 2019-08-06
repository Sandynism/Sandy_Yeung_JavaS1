package com.company;

import com.opencsv.bean.CsvBindByName;

public class Classmate {
    @CsvBindByName(column="Name")
    private String name;
    @CsvBindByName(column= "OperatingSystem")
    private String operatingSystem;
    @CsvBindByName(column= "FavoriteBand")
    private String favoriteBand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getFavoriteBand() {
        return favoriteBand;
    }

    public void setFavoriteBand(String favoriteBand) {
        this.favoriteBand = favoriteBand;
    }

}

//Create a csv that contains information about your classmates. Include Name, Operating System (Mac or Windows), and Favorite Band (Ask your classmates if you don't know).
//
//  Once you have 10 names in your CSV, using the code from the previous example as a reference, create a ClassMate class with all the necessary properties (include getters and setters).
//
//  Use OpenCSV to read the data into a List of ClassMates and print the results.
//
//  _Don't forget your Maven dependencies._