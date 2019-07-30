package com.company;

public class ComputerMouse {
    public String manufacturer;
    public String model;
    public int xPosition;
    public int yPosition;
    public int[] lastClickedLocation;

    public ComputerMouse(String newManufacturer, String newModel, int newXPosition, int newYPosition, int[] newLastClickedLocation) {
        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.xPosition = newXPosition;
        this.yPosition = newYPosition;
        this.lastClickedLocation = newLastClickedLocation;
    }

    public void move(int deltaX, int deltaY) {
    }

    public void click() {
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getxPosition() {
        return this.xPosition;
    }

    public int getyPosition() {
        return this.yPosition;
    }

    public int[] getLastClickedLocation() {
        return this.lastClickedLocation;
    }

}
