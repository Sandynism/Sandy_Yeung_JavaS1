package com.company;

import java.util.Scanner;

public class MonthConverterIf {

    public static int promptUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void convertToMonth(int userNumber) {
        if (userNumber < 1 || userNumber > 12) {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        } else if (userNumber == 1) {
            System.out.println("January");
        } else if (userNumber == 2) {
            System.out.println("February");
        } else if (userNumber == 3) {
            System.out.println("March");
        } else if (userNumber == 4) {
            System.out.println("April");
        } else if (userNumber == 5) {
            System.out.println("May");
        } else if (userNumber == 6) {
            System.out.println("June");
        } else if (userNumber == 7) {
            System.out.println("July");
        } else if (userNumber == 8) {
            System.out.println("August");
        } else if (userNumber == 9) {
            System.out.println("September");
        } else if (userNumber == 10) {
            System.out.println("October");
        } else if (userNumber == 11) {
            System.out.println("November");
        } else if (userNumber == 12) {
            System.out.println("December");
        }
    }

    public static void main(String[] args) {
        int month = promptUser();
        convertToMonth(month);
    }
}


//Prompt the user to enter a number between 1 and 12.
//Print out the name of the month corresponding to the number typed in by the user.
//Print out the following error message if the user enters a number less than 1 or greater than 12: "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye."