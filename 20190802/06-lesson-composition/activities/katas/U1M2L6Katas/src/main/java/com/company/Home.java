package com.company;

public class Home{
    public static void main(String[] args) {
        Bedroom bedroom = new Bedroom();
        LivingRoom livingRoom = new LivingRoom();
        DiningRoom diningRoom = new DiningRoom();
        Kitchen kitchen = new Kitchen();

        bedroom.setBedCount(1);
        bedroom.setClosetCount(2);
        bedroom.getSquareFootage();
        bedroom.setBathroomCount(1);
        bedroom.isAirConditioned();
        bedroom.setFurnished(false);

        livingRoom.setCoffeeTable(1);
        livingRoom.setLamps(2);
        livingRoom.setSofa(2);
        livingRoom.setTv(3);
        livingRoom.setDoorCount(1);
        livingRoom.setFloorType("carpet");

        diningRoom.setFloorType("granite");
        diningRoom.setChairCount(6);
        diningRoom.setWallType("painted");
        diningRoom.getWallType();
        diningRoom.setTableCount(1);

        kitchen.setCabinetsCount(10);
        kitchen.setFridgeCount(2);
        kitchen.setOvenCount(2);
        kitchen.setSinkCount(2);
        kitchen.setStoveCount(1);
        kitchen.setFurnished(true);

    }

}

//Create a class representing a home. It should be comprised of the below objects. Each object should have state and behavior appropriate to them (square footage, length, width, flooring type, etc).
//Start by first creating a UML diagram. Then, using that as your guide, write the code for the class.
//
//Basement
//Bathroom
//Kitchen
//Patio
//Etc.
