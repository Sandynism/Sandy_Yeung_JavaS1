package com.company;

public class DiningRoom extends Room {
    public DiningRoom() {}

    int tableCount, chairCount;
    boolean isAirConditioned;

    public int getTableCount() {
        return tableCount;
    }

    public void setTableCount(int tableCount) {
        this.tableCount = tableCount;
    }

    public int getChairCount() {
        return chairCount;
    }

    public void setChairCount(int chairCount) {
        this.chairCount = chairCount;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public void setIsAirConditioned(boolean isAirConditioned) {
        this.isAirConditioned = isAirConditioned;
    }



}
