package com.company;

public class Bedroom extends Room {
    public Bedroom() {}

    int bedCount, closetCount, bathroomCount;
    boolean isAirConditioned;

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public void setIsAirConditioned(boolean isAirConditioned) {
        this.isAirConditioned = isAirConditioned;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getClosetCount() {
        return closetCount;
    }

    public void setClosetCount(int closetCount) {
        this.closetCount = closetCount;
    }


}
