package com.company;

public class Room {
    public Room() {
    }

    int squareFootage, windowCount, doorCount;
    String floorType, wallType;
    boolean isFurnished;

    public Room(int squareFootage, int windowCount, int doorCount, String floorType, String wallType) {
        this.squareFootage = squareFootage;
        this.windowCount = windowCount;
        this.doorCount = doorCount;
        this.floorType = floorType;
        this.wallType = wallType;
    }


    public int getSquareFootage() {
        return squareFootage;
    }

    public int getWindowCount() {
        return windowCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public String getWallType() {
        return wallType;
    }

    public void setWallType(String wallType) {
        this.wallType = wallType;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public void setFurnished(boolean furnished) {
        isFurnished = furnished;
    }
}
