package com.company;

public class LivingRoom extends Room {
    public LivingRoom() {}

    int sofa, tv, coffeeTable, lamps;
    boolean isAirConditioned;

    public int getSofa() {
        return sofa;
    }

    public void setSofa(int sofa) {
        this.sofa = sofa;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getCoffeeTable() {
        return coffeeTable;
    }

    public void setCoffeeTable(int coffeeTable) {
        this.coffeeTable = coffeeTable;
    }

    public int getLamps() {
        return lamps;
    }

    public void setLamps(int lamps) {
        this.lamps = lamps;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public void setAirConditioned(boolean airConditioned) {
        isAirConditioned = airConditioned;
    }


}
