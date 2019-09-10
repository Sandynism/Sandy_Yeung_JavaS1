package com.company;

public class Farmer extends Character{

    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);
    }

    public void plow() {
        System.out.println("I am plowing away.");
    }
    public void harvest() {
        System.out.println("I am harvesting.");
    }
}

////Farmer
////  * Properties:
////    * name
////    * strength (initial value = 75)
////    * health (initial value = 100)
////    * stamina (initial value = 75)
////    * speed (initial value = 10)
////    * attackPower (initial value = 1)
////  * Abilities:
////    * run
////    * plow
////    * harvest
////    * attack
////    * heal
////    * decreaseHealth
////    * increaseStamina
////    * decreaseStamina