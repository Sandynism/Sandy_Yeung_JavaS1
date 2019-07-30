package com.company;

public class Microwave {
    public String manufacturer;
    public String model;
    public int secondsLeft;
    public String time;
    public boolean running;

    public Microwave(String newManufacturer, String newModel, int newSecondsLeft, String newTime, boolean newRunning) {
        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.secondsLeft = newSecondsLeft;
        this.time = newTime;
        this.running = newRunning;
    }

    public void start(int secondsLeft) {
    }

    public void stop() {
    }

    public void clear() {
    }


    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getSecondsLeft() {
        return this.secondsLeft;
    }

    public String getTime() {
        return this.time;
    }

    public boolean isRunning() {
        return this.running;
    }
}
