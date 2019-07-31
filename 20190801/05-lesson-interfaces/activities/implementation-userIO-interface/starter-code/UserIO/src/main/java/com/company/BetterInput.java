package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class BetterInput implements UserIO {
    Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                int userInt = Integer.parseInt(scanner.nextLine());
                return userInt;
            } catch (Exception e) {
                System.out.printf("That’s not an integer. Try again.%n");
            }
        }
    }

    public long readLong(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                long userLong = Long.parseLong(scanner.nextLine());
                return userLong;
            } catch (Exception e) {
                System.out.printf("That's not a long. Try again.%n");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                double userDouble = Double.parseDouble(scanner.nextLine());
                return userDouble;
            } catch (Exception e) {
                System.out.printf("That's not a double. Try again.%n");
            }
        }
    }

    public float readFloat(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                float userFloat = Float.parseFloat(scanner.nextLine());
                return userFloat;
            } catch (Exception e) {
                System.out.printf("That's not a float. Try again.%n");
            }
        }
    }

    public String readString(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String userString = scanner.nextLine();
                return userString;
            } catch (Exception e) {
                System.out.printf("That's not a string. Try again.%n");
            }
        }
    }

    public static void main(String[] args) {

    }
}

//      If a user is asked to enter an integer value and instead inputs a string, Java will throw an Exception. This simply means that something went wrong and that Java generated some kind of error because of it.
//        Create a new class called BetterInput, which implements the UserIO interface but also handles exceptions thrown because of bad user input. When bad input is received, your methods should continue to prompt users for input until valid input is received. You will need to use a try...catch block as well as recursion to most effectively accomplish this.
//        Once completed, change userInput to instantiate BetterInput instead of Input, and run Application to test your code.
//        Read about try...catch blocks and recursion to help guide you through this.
//        Hint: If an error occurs, the method should call itself again with the same prompt as before.