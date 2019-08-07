package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TelevisionReader {
    public static void main(String[] args) {
        //Read the data from the .json and store it as a List.
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisions;

            televisions = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            for (Television television : televisions) {
                System.out.println("================List");
                System.out.println(television.getBrand());
                System.out.println(television.getModel());
                System.out.println(television.getPrice());
                System.out.println(television.getScreenSize());
            }

            //Find all televisions with a screen size greater than 60 inches. Use the .forEach method to print out all entries.
            televisions
                    .stream()
                    .filter(television -> television.getScreenSize() > 60)
                    .forEach(television -> {
                        System.out.println("================Screen Size > 60");
                        System.out.println(television.getBrand());
                        System.out.println(television.getModel());
                        System.out.println(television.getPrice());
                        System.out.println(television.getScreenSize());
                    });

            //Group all televisions into a Map by brand. Print out the list of brands.
            Map<String, List<Television>> groupedTelevisions =
                    televisions
                            .stream()
                            .collect(Collectors.groupingBy(t -> t.getBrand()));

            System.out.println("================Brands");
            Set<String> keys = groupedTelevisions.keySet();
            for (String key : keys) {
                System.out.println(key);
            }

            //Find and display the average screenSize.
            double avgScreenSize =
                    televisions
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .average()
                            .getAsDouble();
            System.out.println("================");
            System.out.println("Average Screen Size: " + avgScreenSize);

            //Find and display the largest screen.
            int largestScreen =
                    televisions
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .max()
                            .getAsInt();
            System.out.println("================");
            System.out.println("Largest Screen Size: " + largestScreen);

            //Sort the data by screen size, then print out the sorted list.
//            List<Integer> sortedList =
//                    televisions
//                            .stream()
//                            .filter(television -> television.getScreenSize() > 0)
//                            .sorted()
//                            .collect(Collectors.toList());
//            System.out.println(sortedList);


        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}


