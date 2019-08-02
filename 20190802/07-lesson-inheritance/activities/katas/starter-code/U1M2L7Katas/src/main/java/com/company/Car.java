package com.company;

import com.company.interfaces.Vehicle;

public class Car implements Vehicle {
    public Car(){}

    String make, model;
    int milesTraveled;


    @Override
    public void drive(int miles) {

    }

    @Override
    public void displayMilesTraveled() {

    }
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled = milesTraveled;
    }


}



