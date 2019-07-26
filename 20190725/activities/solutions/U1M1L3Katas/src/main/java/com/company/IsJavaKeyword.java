package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a word:");
        String word = scanner.nextLine();

        switch (word) {

            case "for":
            case "if":
            case "while":
            case "do":
            case "abstract":
            case "assert":
            case "boolean":
            case "break":
            case "byte":
            case "case":
            case "catch":
            case "char":
            case "class":
            case "const":
            case "continue":
            case "default":
            case "double":
            case "else":
            case "enum":
            case "extends":
            case "final":
            case "finally":
            case "float":
            case "goto":
            case "implements":
            case "import":
            case "instanceof":
            case "int":
            case "interface":
            case "long":
            case "native":
            case "new":
            case "package":
            case "private":
            case "protected":
            case "public":
            case "return":
            case "short":
            case "static":
            case "strictfp":
            case "super":
            case "switch":
            case "synchronized":
            case "this":
            case "throw":
            case "throws":
            case "transient":
            case "try":
            case "void":
            case "volatile":
            case "true":
            case "false":
            case "null":
                System.out.println("This is a Java keyword.");
                break;
            default:
                System.out.println("This is not a Java keyword.");

        }

    }
}
