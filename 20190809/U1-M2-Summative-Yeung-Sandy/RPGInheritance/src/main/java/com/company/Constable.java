package com.company;

public class Constable extends Character {
    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);
    }

    String jurisdiction;

    public String arrest(String name) {
        System.out.printf("I caught you fudging %s%n", name);
        return name;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}

// Constable
//  * Properties
//    * name
//    * strength (initial value = 60)
//    * health (initial value = 100)
//    * stamina (initial value = 60)
//    * speed (initial value = 20)
//    * attackPower (initial value = 5)
//    * jurisdiction
//  * Abilities:
//    * run
//    * arrest
//    * attack
//    * heal
//    * decreaseHealth
//    * increaseStamina
//    * decreaseStamina