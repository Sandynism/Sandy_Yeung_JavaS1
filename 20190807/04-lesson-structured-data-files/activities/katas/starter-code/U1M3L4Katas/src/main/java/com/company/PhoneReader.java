package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {
    public static void main(String[] args) {
        //reader
        try {
            ObjectMapper mapper = new XmlMapper();

            List<Phone> phones;

            phones = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>() {
            });

            for (Phone phone : phones) {
                System.out.println("================");
                System.out.println(phone.getBrand());
                System.out.println(phone.getModel());
                System.out.println(phone.getProcessor());
                System.out.println(phone.getStorage());
                System.out.println(phone.getPrice());

            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}

//Open phones.xml and look at the data within.
//Create an appropriate Java object based on the contents of the file.
//Create a Java file called PhoneReader.
//Use Jackson to read the data from the file and store it in a list.
//Print the contents of the list.