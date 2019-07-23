package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        //The purpose of the program is to calculate the total cost to pave a driveway.  Here are the requirements:
        Scanner scanner = new Scanner(System.in);

        //It must prompt the user for the width of the driveway as an integer (in feet).
        System.out.println("What is the width of your driveway?");
        int width = Integer.parseInt(scanner.nextLine());

        //It must prompt the user for the length of the driveway as an integer (in feet).
        System.out.println("What is the length of your driveway?");
        int length = Integer.parseInt(scanner.nextLine());

        //It must calculate and display the area of the driveway.
        int area = width * length;
        System.out.println("The area of the driveway is " + area);

        //It must calculate and display the perimeter of the driveway.
        int perimeter = (width * 2) + (length * 2);
        System.out.println("The perimeter of the driveway is " + perimeter);

        //Based on the area and perimeter, it must calculate the total cost of the driveway:
        // The cement for the driveway cost $12.50/square foot.
        // The program must calculate and display the subtotal cost of the cement.
        double cementCost = area * 12.50;
        System.out.println("The cement cost is " + cementCost);

        //Prompts the user for the cost of cement
        System.out.println("What is the cost of cement?");
        double userCementPrice = Double.parseDouble(scanner.nextLine());
        double userCementSubtotal = area * userCementPrice;
        System.out.println("Based off the user cement price, the cement cost subtotal would be " + userCementSubtotal);


        //The framing/footers for the driveway cost $8.25/linear foot.
        //The program must calculate and display the subtotal cost of the framing/footers.
        double framingCost = perimeter * 8.25;
        System.out.println("The framing costs are " + framingCost);

        //Prompts the user for the cost of the framing/footers
        System.out.println("What is the cost of framing?");
        double userFramingPrice = Double.parseDouble(scanner.nextLine());
        double userFramingSubtotal = area * userFramingPrice;
        System.out.println("Based off the user framing price, the cement cost subtotal would be " + userFramingSubtotal);

    }
}
