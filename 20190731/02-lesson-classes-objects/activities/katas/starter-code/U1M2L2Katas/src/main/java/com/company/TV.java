package com.company;

public class TV {
    public String manufacturer;
    public String model;
    public int screenSize;
    public int volume;
    public String channel;
    public boolean powered;

    public TV(String newManufacturer, String newModel, int newScreenSize, String newChannel, int newVolume, boolean newPowered) {
        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.screenSize = newScreenSize;
        this.volume = newVolume;
        this.channel = newChannel;
        this.powered = newPowered;
    }

    public void togglePower() {
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isPowered() {
        return this.powered;
    }

}


