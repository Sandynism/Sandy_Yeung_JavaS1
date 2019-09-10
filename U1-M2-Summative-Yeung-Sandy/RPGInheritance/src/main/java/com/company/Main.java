package com.company;

public class Main {
    public static void main(String[] args) {

        Farmer farmer = new Farmer("Bobby", 75, 100, 75, 10, 1);
        Constable constable = new Constable("Robocop", 60, 100, 60, 20, 5);
        Warrior warrior = new Warrior("Wonder Woman", 75, 100, 100, 50, 10);

        farmer.plow();
        farmer.harvest();
        System.out.println("Farmer's Stamina: " + farmer.getStamina());
        System.out.println("Farmer's Speed: " + farmer.getSpeed());

        constable.arrest("Bobby");
        System.out.println("Constables initial health: " + constable.getHealth());
        System.out.println("Constable decreased health by: " + constable.decreaseHealth());
        System.out.println("Constables decreased health: " + constable.getHealth());
        System.out.println("Constables health after healing: " + constable.heal());

        System.out.println("Warrior's Name: " + warrior.getName());
        warrior.setShieldStrength(100);
        System.out.println("Warrior's Attack Power: " + warrior.getAttackPower());

    }
}
