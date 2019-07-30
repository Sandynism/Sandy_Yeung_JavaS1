package com.company;

public class CoffeeMaker {
    public String manufacturer;
    public String model;
    public int carafeSize;
    public int cupsLeft;
    public boolean powered;

    public CoffeeMaker(String newManufacturer, String newModel, int newCarafeSize, int newCupsLeft, boolean newPowered) {
        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.carafeSize = newCarafeSize;
        this.cupsLeft = newCupsLeft;
        this.powered = newPowered;
    }

    public void brew() {
    }

    public void pourCoffee(int numCups) {
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getCarafeSize() {
        return this.carafeSize;
    }

    public int getCupsLeft() {
        return this.cupsLeft;
    }

    public boolean isPowered() {
        return this.powered;
    }
}
