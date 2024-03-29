package com.company.csv;

import com.company.Motorcycle;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;
import com.company.Classmate;

public class AppOpenCSVReadObjects {

    public static void main(String[] args) {
//        try {
//            List<Motorcycle> bikes =
//                    new CsvToBeanBuilder<Motorcycle>(new FileReader("new_moto_file.csv")).withType(Motorcycle.class).build().parse();
//
//            for (Motorcycle bike : bikes) {
//                System.out.println("=================================");
//                System.out.println(bike.getMake());
//                System.out.println(bike.getModel());
//                System.out.println(bike.getYear());
//                System.out.println(bike.getColor());
//                System.out.println(bike.getDisplacement());
//                System.out.println(bike.getHorsepower());
//                System.out.println(bike.getWeight());
//
//                // Now let's write the motorcycle list to another file
//                Writer writer = new FileWriter("new_moto_file.csv");
//                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
//                beanToCsv.write(bikes);
//                writer.close();
//
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Could not find CSV file: " + e.getMessage());
//        }catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
//            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
//        }



        try {
            List<Classmate> classmates =
                    new CsvToBeanBuilder<Classmate>(new FileReader("classmates.csv")).withType(Classmate.class).build().parse();

            for (Classmate classmate : classmates) {
                System.out.println("=================================");
                System.out.println(classmate.getName());
                System.out.println(classmate.getOperatingSystem());
                System.out.println(classmate.getFavoriteBand());

                // Now let's write the motorcycle list to another file
                Writer writer = new FileWriter("new_classmates.csv");
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(classmates);
                writer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        }


    }

}
