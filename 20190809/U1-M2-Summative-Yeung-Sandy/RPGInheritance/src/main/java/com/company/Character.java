package com.company;

public class Character {

    String name;
    int strength, health, stamina, speed, attackPower;

    public Character(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    public void run() {
        System.out.println("I am running and running!");
    }

    public void attack() {
        System.out.println("ATTTTTTAAAAACK");
    }

    public int heal() {
        health += 25;
        return health;
    }

    public int decreaseStamina() {
        stamina -= 10;
        return stamina;
    }

    public int increaseStamina() {
        stamina += 10;
        return stamina;
    }

    public int decreaseHealth() {
        health -= 15;
        return health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

}

//Farmer
//  * Properties:
//    * name
//    * strength (initial value = 75)
//    * health (initial value = 100)
//    * stamina (initial value = 75)
//    * speed (initial value = 10)
//    * attackPower (initial value = 1)
//  * Abilities:
//    * run
//    * plow
//    * harvest
//    * attack
//    * heal
//    * decreaseHealth
//    * increaseStamina
//    * decreaseStamina