package com.company;

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi Julio! Please enter your earth weight.");
        float earthWeight = Float.parseFloat(scanner.nextLine());
        System.out.println("Please enter a number for the planet you want to fight on.");
        int planet = Integer.parseInt(scanner.nextLine());


        if (planet == 1) {
            System.out.println("Your weight on Venus is " + earthWeight * 0.78);
        }
        if (planet == 2) {
            System.out.println("Your weight on Mars is " + earthWeight * 0.39);
        }
        if (planet == 3) {
            System.out.println("Your weight on Jupiter is " + earthWeight * 2.65);
        }
        if (planet == 4) {
            System.out.println("Your weight on Saturn is " + earthWeight * 1.17);
        }
        if (planet == 5) {
            System.out.println("Your weight on Uranus is " + earthWeight * 1.05);
        }
        if (planet == 6) {
            System.out.println("Your weight on Neptune is " + earthWeight * 1.23);
        }
        else if (planet < 1 || planet > 6 ){
            System.out.println("Please enter a valid number.");
        }
    }
}


//Julio Cesar Chavez Mark VII is an interplanetary space boxer, who currently holds the championship belts for various weight categories on many different planets within our solar system. However, it is often difficult for him to recall what his "target weight" needs to be on earth in order to make the weight class on other planets.	Write a program to help him keep track of this.
//
//It should ask him what his earth weight is, and to enter a number for the planet he wants to fight on. It should then compute his weight on the destination planet based on the table below:
//#	Planet	Relative gravity
//1	Venus	0.78
//2	Mars	0.39
//3	Jupiter	2.65
//4	Saturn	1.17
//5	Uranus	1.05
//6	Neptune	1.23
//So, for example, if Julio weighs 128 lbs. on earth, then he would weigh just under 50 lbs. on Mars, since Mars' gravity is 0.39 times earth's gravity. (128 * 0.39 is 49.92)