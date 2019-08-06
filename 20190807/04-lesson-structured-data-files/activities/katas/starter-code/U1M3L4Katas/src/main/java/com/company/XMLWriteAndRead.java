package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {
    public static void main(String[] args) {
        PrintWriter writer = null;

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Camry");
        car1.setYear(2012);
        car1.setColor("Blue");

        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear(2001);
        car2.setColor("Silver");

        Car car3 = new Car();
        car3.setMake("Jeep");
        car3.setModel("Wrangler");
        car3.setYear(2009);
        car3.setColor("Rust");

        Car car4 = new Car();
        car4.setMake("Tesla");
        car4.setModel("Roadster");
        car4.setYear(2018);
        car4.setColor("Black");

        Car car5 = new Car();
        car5.setMake("Ford");
        car5.setModel("Mustang");
        car5.setYear(1964);
        car5.setColor("Red");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        //writer
        try {
            ObjectMapper mapper = new XmlMapper();
            String xmlCarList = mapper.writeValueAsString(carList);

            System.out.println(xmlCarList);


            writer = new PrintWriter(new FileWriter("carList.xml"));

            writer.println(xmlCarList);


        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

        //reader
        try {
            ObjectMapper mapper = new XmlMapper();

            List<Car> cars;

            cars = mapper.readValue(new File("carList.xml"), new TypeReference<List<Car>>() {
            });

            for (Car car : cars) {
                System.out.println("================");
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
                System.out.println(car.getColor());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
