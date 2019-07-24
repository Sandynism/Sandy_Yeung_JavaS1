package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        //Find the average of 3 numbers inputted by the user.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me a random number");
        float num1 = Float.parseFloat(scanner.nextLine());
        System.out.println("Please give me a second random number");
        float num2 = Float.parseFloat(scanner.nextLine());
        System.out.println("Please give me a third random number");
        float num3 = Float.parseFloat(scanner.nextLine());

//      double average = (num1 + num2 + num3) / 3.00;
//      System.out.println(average);

        float[] arr = {num1, num2, num3};
        float total = 0f;
            for(int i=0; i<arr.length; i++) {
                total = total + arr[i];
            }

        float average = total / arr.length;
        System.out.println(average);
        System.out.format("The average of these numbers is %f%n", average);
        //format allows you to take the response and use as a variable elsewhere
        /*format is a string that specifies the formatting to be used and args is a list of the variables to be printed using that formatting. A simple example would be

        System.out.format("The value of " + "the float variable is " +
                "%f, while the value of the " + "integer variable is %d, " +
                "and the string is %s", floatVar, intVar, stringVar);
                */


    }
}

//import java.text.DecimalFormat;
// DecimalFormat df = new DecimalFormat("###.###");
//System.out.println(df.format(PI));