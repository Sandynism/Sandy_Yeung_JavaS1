package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {
    //Write a program that continues to ask for the user's favorite programming language until they type in "Java".
    // Once they do, print "That's what I was looking for! Java is definitely the answer!"
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String correctLang = "Java".toLowerCase();

        do {
            System.out.println("Please tell me your favorite programming language!");
            userInput = scanner.nextLine().toLowerCase();
        } while (!userInput.equals(correctLang));
        if (userInput.equals(correctLang)) {
            System.out.println("That's what I was looking for! Java is definitely the answer!");
        }
    }
}
