package com.company;

public class Warrior extends Character {
    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);
    }

    int shieldStrength;

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public int decreaseShieldStrength(int shieldStrength) {
        shieldStrength -= 10;
        return shieldStrength;
    }

}

// * Properties
//    * name
//    * strength (initial value = 75)
//    * health (initial value = 100)
//    * stamina (initial value = 100)
//    * speed (initial value = 50)
//    * attackPower (initial value = 10)
//    * shieldStrength (initial value = 100)
//  * Abilities:
//    * run
//    * attack
//    * heal
//    * decreaseHealth
//    * increaseStamina
//    * decreaseStamina
//    * decreaseShieldStrength