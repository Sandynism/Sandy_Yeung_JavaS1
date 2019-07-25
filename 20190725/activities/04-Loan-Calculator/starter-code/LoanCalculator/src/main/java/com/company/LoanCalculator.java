package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static double calculateMonthlyPayment(int mortgageAmt, int termLength, int interestRate) {

        // Convert interest rate into a decimal
        // eg. 6.5% = 0.065

        interestRate /= 100.0;

        // Monthly interest rate
        // is the yearly rate divided by 12

        double monthlyRate = interestRate / 12.0;

        // The length of the term in months
        // is the number of years times 12

        int termInMonths = termLength * 12;

        // Calculate the monthly payment
        // Typically this formula is provided so
        // we won't go into the details

        // The Math.pow() method is used calculate values raised to a power

        double monthlyPayment =
                (mortgageAmt*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonths));

        return monthlyPayment;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your mortgage amount.");
        int mortgageAmt = scanner.nextInt();
        System.out.println("Please enter your mortgage term.");
        int termLength = scanner.nextInt();
        System.out.println("Please enter your annual interest rate.");
        int interestRate = scanner.nextInt();

        double monthlyPayment =
                calculateMonthlyPayment(mortgageAmt, termLength, interestRate);

        System.out.println("Your monthly interest rate is " + monthlyPayment);
    }
}


//    Write a Java program that calculates and displays the mortgage payment amount given the following:
//
//        The amount of the mortgage
//        The term of the mortgage
//        The annual interest rate of the mortgage
//
//        For the formula to calculate the payment, use the first formula found here.
//
//        Hints
//
//        Remember to divide the annual interest rate by 100. For example, if the annual interest rate is 12%, you must use .12 in your calculation.
//        The monthly interest rate is equal to the annual interest rate divided by 12.