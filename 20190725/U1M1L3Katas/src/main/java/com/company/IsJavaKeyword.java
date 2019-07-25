package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class IsJavaKeyword {
    //Write a program that get user input (a String) and print out whether or not it is a Java keyword. You will need to find a list of keywords for this kata.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do",
                "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

        System.out.println("Type any word and I can tell you if it is a Java keyword!");
        String userInput = scanner.nextLine();

        //newest way to write java loops
//        for (String keyword: keywords)
//        {
//            if (userInput.equals(keyword)) {
//                isKeyword = true;
//                System.out.printf("Don't use it! %s is a keyword!\n", userInput);
//            } else {
//              System.out.printf("You can use it! %s is not a keyword!\n", userInput);
//            }
//        }

        boolean result = Arrays.stream(keywords).anyMatch(userInput::equals);
        if (result) {
            System.out.printf("Don't use it! %s is a java keyword!\n", userInput);
        } else {
            System.out.printf("You can use it! %s is not a java keyword!\n", userInput);
        }
    }
}
