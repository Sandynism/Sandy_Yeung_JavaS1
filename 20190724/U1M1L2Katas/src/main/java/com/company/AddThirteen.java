package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        //Add 13 to the value inputted by the user and print the result to the screen.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me a random number");
        int num1 = Integer.parseInt(scanner.nextLine());

        double addThirteen = (num1 + 13);
        System.out.println(addThirteen);
    }
}
