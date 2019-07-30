package com.company;

public class Radio {
    public String manufacturer;
    public String model;
    public int numSpeaker;
    public String station;
    public int volume;
    public boolean powered;

    public Radio(String newManufacturer, String newModel, int newNumSpeaker, String newStation, int newVolume, boolean newPowered) {
        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.numSpeaker = newNumSpeaker;
        this.station = newStation;
        this.volume = newVolume;
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

    public int getNumSpeakers() {
        return this.numSpeaker;
    }

    public String getStation() {
        return this.station;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isPowered() {
        return this.powered;
    }
}
