package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        do {
            System.out.println("Please enter your favorite programming language:");
            input = scanner.nextLine();
        } while (!input.equals("Java"));

        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}
