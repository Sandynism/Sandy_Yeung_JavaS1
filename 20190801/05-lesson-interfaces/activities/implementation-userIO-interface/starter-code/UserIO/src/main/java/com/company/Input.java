package com.company;
import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {
    Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt) {
        System.out.println(prompt);
        int userInt = Integer.parseInt(scanner.nextLine());
        return userInt;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        long userLong = Long.parseLong(scanner.nextLine());
        return userLong;
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        double userDouble = Double.parseDouble(scanner.nextLine());
        return userDouble;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        float userFloat = Float.parseFloat(scanner.nextLine());
        return userFloat;
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        String userString = scanner.nextLine();
        return userString;
    }

    public static void main(String[] args) {

    }
}

//       The methods in your Input class must contain the logic to read the value in, convert it to the appropriate type,
//         and return it to the user. A main method has been provided, which utilizes this class in the Application class.
