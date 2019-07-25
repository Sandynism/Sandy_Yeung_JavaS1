package com.company;

public class App {
    //Subtract Two: Create a method called subtract that takes two int parameters (a and b) and returns the value of b subtracted from a.
    public static int subtractTwo(int a, int b) {
        int answer = a - b;
        return answer;
    }

    //Subtract or Zero: Create a method called subtractOrZero that takes two int parameters (a and b) and returns the value of b subtracted from a, unless the result is less than zero, in which case, return 0.
    public static int subtractOrZero(int a, int b) {
        int answer = a - b;
        if(answer < 0) {
            return 0;
        } else return answer;
    }

    //Max: Create a method called max that takes three int parameters (a, b, and c) and returns the value of the largest of the three.
    public static int max(int a, int b, int c) {
        if(a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    //Min: Create a method called min that takes three int parameters (a, b, and c) and returns the value of the smallest of the three.
    public static int min(int a, int b, int c) {
        if(a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    //isLarger: Create a method called isLarger that takes two int parameters (first and second) and returns true if the first is greater than second.
    public static String isLarger(int first, int second) {
        if(first > second) {
            return "true";
        } else {
            return "false";
        }
    }

    public static void main(String[] args) {

        System.out.println("Subtract Two: " + subtractTwo(22, 10));
        System.out.println("Subtract Or Zero: " + subtractOrZero(10, 22));
        System.out.println("Max: " + max(3, 7, 10));
        System.out.println("Min: " + min(3, 7, 10));
        System.out.println("Is Larger: " + isLarger(8, 10));

    }
}

