package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        // The purpose of this program is to prompt the user for registration information for a new social media service called CommandLineGram.
        Scanner scanner = new Scanner(System.in);

        // First name
        System.out.println("What is your first name?");
        String firstName = scanner.nextLine();

        // Last name
        System.out.println("What is your last name?");
        String lastName = scanner.nextLine();

        // Email
        System.out.println("What is your email address?");
        String email = scanner.nextLine();

        // Twitter handle
        System.out.println("What is your Twitter handle?");
        String twitterHandle = scanner.nextLine();

        // Age
        System.out.println("What is your age?");
        int age = Integer.parseInt(scanner.nextLine());

        // Country
        System.out.println("What is the country you live in?");
        String country = scanner.nextLine();

        // Profession
        System.out.println("What is your profession?");
        String profession = scanner.nextLine();

        // Favorite operating system
        System.out.println("What is your favorite operating system?");
        String faveOperatingSystem = scanner.nextLine();

        // Favorite programming language
        System.out.println("What is your your favorite programming language?");
        String faveProgrammingLang = scanner.nextLine();

        // Favorite computer scientist
        System.out.println("What is your favorite computer scientist?");
        String faveComScientist = scanner.nextLine();

        // Favorite keyboard shortcut
        System.out.println("What is your favorite keyboard shortcut?");
        String faveKeyShortcut = scanner.nextLine();

        // Have you ever built your own computer?
        System.out.println("Have you ever built your own computer?");
        String comBuilder = scanner.nextLine();
//        String output=(comBuilder="yes")?"Yes, I have built my own computer.":"No, I have not built my own computer.";
//        System.out.println(output);

        // If you could be any superhero, who would it be?
        System.out.println("If you could be any superhero, who would it be?");
        String superhero = scanner.nextLine();

        // The program must prompt the user for the following information and then display it, nicely formatted, back to the user after all the information has been collected:
        System.out.println("Hello " + firstName + " " + lastName + "." + "\n" + "Just to confirm, you said your email address was " + email +
                " and that your Twitter handle was " + twitterHandle + "." + "\n" + "You are " + age + " years old and live in " + country + " and work as a " + profession + ". " + "\n"
        + "Your favorite operating system is " + faveOperatingSystem + "." + "\n" + "Your favorite programming language is " + faveProgrammingLang + "." + "\n"
        + "Your favorite computer scientist is " + faveComScientist + "." + "\n"
        + "Your favorite keyboard shortcut is " + faveKeyShortcut + "." + "\n" + "My favorite superhero would be " + superhero + ".");

    }
}


