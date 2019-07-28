package com.company;

public class SomeMath {
    public static int total5(int a, int b, int c, int d, int e) {
        int total = a + b + c + d + e;
        System.out.println(total);
        return total;
    }

    public static double average5(int a, int b, int c, int d, int e) {
        double average = (a + b + c + d + e) / 5;
        System.out.println(average);
        return average;
    }

    public static double largest5(double a, double b, double c, double d, double e) {
        double largest = a;

        if (b > largest) {
            largest = b;
        }
        if (c > largest) {
            largest = c;
        }
        if (d > largest) {
            largest = d;
        }
        if (e > largest) {
            largest = e;
        }
        System.out.println(largest);
        return largest;
    }

    public static void main(String[] args) {
        total5(1, 2, 3, 4, 5);
        average5(1, 3, 5, 7, 9);
        largest5(42.0, 35.1, 2.3, 40.2, 15.6);
    }

}

//In this program, you will create three methods and call them from main with the specified parameters. Your solution must be in a Java file called SomeMath.
//
//Create a method called total5.  This method must take 5 int parameters and return the total. You must call the method with the following parameters and print the returned total to the screen: 1, 2, 3, 4, 5.
//Create a method called average5. This method must take 5 int parameters and return the average of the numbers as a double. You must call the method with the following parameters and print the returned average to the screen: 1, 3, 5, 7, 9.
//Create a method called largest5. This method must take 5 double parameters and return the largest. You must call the method with the following parameters and print the returned value to the screen: 42.0, 35.1, 2.3, 40.2, 15.6.