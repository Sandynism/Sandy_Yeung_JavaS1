package com.company;

public class Laptop {
//    public Laptop() {}

    int processorSpeed, ram, hardDriveSpace, price, makeYear, speakerCount;
    String brandName, model, currentVersion, user;

    public Laptop(int processorSpeed, int ram, int hardDriveSpace, int price, int makeYear, int speakerCount, String brandName, String model, String currentVersion) {
        this.processorSpeed = processorSpeed;
        this.ram = ram;
        this.hardDriveSpace = hardDriveSpace;
        this.price = price;
        this.makeYear = makeYear;
        this.speakerCount = speakerCount;
        this.brandName = brandName;
        this.model = model;
        this.currentVersion = currentVersion;
    }

    public int getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(int processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDriveSpace() {
        return hardDriveSpace;
    }

    public void setHardDriveSpace(int hardDriveSpace) {
        this.hardDriveSpace = hardDriveSpace;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMakeYear() {
        return makeYear;
    }
    public void setMakeYear(int makeYear) {
        this.makeYear = makeYear;
    }

    public void setSpeakerCount(int speakerCount) {
        this.speakerCount = speakerCount;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public void setUser(String user) {
        this.user = user;
    }


}

//Create a class representing a laptop. It should be comprised of the below objects. Add any additional objects that you feel should be modeled as well. Each object should have state and behavior appropriate to them.
//Start by first creating a UML diagram. Then, using that as your guide, write the code for the class.
//
//Processor
//Memory
//Optical Drive
//Etc.