package com.company;

public class Accord extends Sedan {
    public Accord(){}

    String year;
    Engine engine;
    Transmission transmission;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Engine setEngine(Engine engine) {
        this.engine = engine;
        return engine;
    }

    public Transmission setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return transmission;
    }

}
