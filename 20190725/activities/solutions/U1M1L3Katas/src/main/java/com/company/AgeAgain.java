package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = 0;
        String input = "";

        System.out.println("Please enter your age:");
        input = scanner.nextLine();
        age = Integer.parseInt(input);

        if (age < 14) {
            System.out.println("What grade are you in?");
            input = scanner.nextLine();
            System.out.println("Wow! " + input + " grade - that sounds exciting!");
        } else if (age >= 14 && age <=18) {
            System.out.println("Are you planning to go to college?");
            input = scanner.nextLine();
            if (input.equals("yes")) {
                System.out.println("Where are you planning to go?");
                input = scanner.nextLine();
                System.out.println(input + " is a great school!");
            } else {
                System.out.println("What do you want to do after high school?");
                input = scanner.nextLine();
                System.out.println("Wow, " + input + " sounds like a plan!");
            }
        } else {
            System.out.println("What is your job?");
            input = scanner.nextLine();
            System.out.println(input + " sounds like a great job!");
        }
    }
}
