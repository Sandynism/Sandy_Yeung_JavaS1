package com.company;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        try {
            System.out.println("Current saved animals file:");
            Pets.readPetsFromFile();

            int petIndex = Pets.choosePet();

            String chosenPet = Pets.retrievePet(petIndex);

            Pets.writePetToFile(chosenPet);

            System.out.println("New saved animals file:");
            Pets.readPetsFromFile();
        }catch (IOException e){
            System.out.println("The following file does not seem to exist: " + e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("Please enter a valid number.");
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Please choose an available pet.");
        }catch(Exception e) {
            System.out.println("Something went wrong while writing your file.");
        }finally{
            System.out.println("Have a nice day!");
        }
    }
}

//Handle the following exceptions:
//
//When a user enters a non-integer value, display "Please enter a valid number."
//When a user chooses a value not present in the array, display "Please choose an available pet."
//If the file does not exist, display the message "The following file does not seem to exist:" along with the output from the Exception .getMessage().
//If there was trouble writing the file, display "Something went wrong while writing your file."
//Regardless of success or exceptions, tell the user to "Have a nice day!"
//
//Note The test will delete pets.txt, so you may need to recreate it in the root of your project directory.