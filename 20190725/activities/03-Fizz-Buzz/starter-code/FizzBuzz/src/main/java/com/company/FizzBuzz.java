package com.company;

public class FizzBuzz {
    public static void main(String[] args) {
        for(int i =0; i <100; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                System.out.println("FIZZBUZZ");
            } else if (i % 3 == 0 && i != 0) {
                System.out.println("FIZZ");
            }
            else if (i % 5 == 0 && i != 0) {
                System.out.println("BUZZ");
            } else {
                System.out.println(i);
            }
        }
    }
}



//
//    Complete the below requirements in the FizzBuzz project found in the starter-code directory.
//        All code must be contained within the main method of the FizzBuzz class.
//        The requirements must be implemented in the order found below.
//        Once your code has been written, it can be tested using FizzBuzzTest.
//
//        ##Requirements
//
//        Print out the numbers from 1 to 100 with the following exceptions:
//
//        If the number is a multiple of 3, print FIZZ instead of the number.
//        If the number is a multiple of 5, print BUZZ instead of the number.
//        If the number is a multiple of 3 and 5, print FIZZBUZZ instead of the number.