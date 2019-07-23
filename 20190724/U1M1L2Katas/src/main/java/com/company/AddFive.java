package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        //Add 5 numbers inputted by the user.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me a random number");
        int num1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please give me a second random number");
        int num2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please give me a third random number");
        int num3 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please give me a fourth random number");
        int num4 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please give me a fifth random number");
        int num5 = Integer.parseInt(scanner.nextLine());

        double addFive = (num1 + num2 + num3 + num4 + num5);
        System.out.println(addFive);
    }
}
