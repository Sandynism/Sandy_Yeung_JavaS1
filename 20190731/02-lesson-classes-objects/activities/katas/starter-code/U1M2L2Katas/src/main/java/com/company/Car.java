package com.company;

public class Car {
    public String make;
    public String model;
    public String type;
    public String color;
    public String engine;
    public String transmission;
    public int numDoors;
    public double mpg;
    public int milesDriven;

    public Car(String newMake, String newModel, String newType, String newColor, String newEngine, String newTransmission, int newNumDoors, double newMpg, int newMilesDriven) {
        this.make = newMake;
        this.model = newModel;
        this.type = newType;
        this.color = newColor;
        this.engine = newEngine;
        this.transmission = newTransmission;
        this.numDoors = newNumDoors;
        this.mpg = newMpg;
        this.milesDriven = newMilesDriven;
    }

    public void drive(int miles) {
    }

    public void honk() {
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getEngine() {
        return this.engine;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public int getNumDoors() {
        return this.numDoors;
    }

    public double getMpg() {
        return this.mpg;
    }

    public int getMilesDriven() {
        return this.milesDriven;
    }
}
