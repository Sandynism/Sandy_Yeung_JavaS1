package com.company;

import java.util.Scanner;

public class AgeAgain {
    //    Write a program that asks for the user's age and then asks a follow-up question based on the value:
//    Less than 14: Ask what grade they're in and then prints "Wow! [user answer] grade - that sounds exciting!"
//    Between 14 and 18 (inclusive): Ask if they're planning to go to college.
//    If the answer is "yes" (all lowercase), ask what college and then print "[user answer] is a great school!".  If the answer is "no" (all lowercase), ask what they want to do after high school, then print "Wow,  sounds like a plan!"
//    Greater than 18: Ask what their job is, then print "[user answer] sounds like a great job!"
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your age?");
        int userAge = scanner.nextInt();
        scanner.nextLine();

        if (userAge < 14) {
            System.out.println("What grade are you in?");
            String grade = scanner.nextLine();
            System.out.printf("Wow! %s grade - that sounds exciting!", grade);
//            System.out.println("Wow! " + grade + " grade - that sounds exciting!");

        } else if ((userAge >= 14) && (userAge <= 18)) {
            System.out.println("Are you planning on going to college?");
            String userResponse = scanner.nextLine().toLowerCase();
            if (userResponse.equals("yes")) {
                System.out.println("What college are you going to?");
                String college = scanner.nextLine();
                System.out.printf("%s is a great school!", college);
//                System.out.println(college + " is a great school!");
            } else {
                System.out.println("What do you plan to do after high school?");
                String plans = scanner.nextLine();
                System.out.printf("Wow, %s sounds like a plan!", plans);
//                System.out.println("Wow, sounds like a plan!");
            }
        } else {
            System.out.println("What is your occupation?");
            String occupation = scanner.nextLine();

            System.out.printf("%s sounds like a great job!", occupation);
//            System.out.println(occupation + " sounds like a great job!");
        }
    }
}
