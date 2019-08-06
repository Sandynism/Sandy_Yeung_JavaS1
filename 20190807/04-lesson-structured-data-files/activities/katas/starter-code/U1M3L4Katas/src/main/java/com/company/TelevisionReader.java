package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelevisionReader {
    public static void main(String[] args) {
        //reader
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisions;

            televisions = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            for (Television television : televisions) {
                System.out.println("================");
                System.out.println(television.getBrand());
                System.out.println(television.getModel());
                System.out.println(television.getPrice());
                System.out.println(television.getScreenSize());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}

//Open televisions.json and look at the data within.
//Create an appropriate Java object based on the contents of the file.
//Create a Java file called TelevisionReader.
//Use Jackson to read the data from the file and store it in a list.
//Print the contents of the list.