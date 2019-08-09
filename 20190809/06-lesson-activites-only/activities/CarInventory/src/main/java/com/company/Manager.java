package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    PrintWriter writer = null;
    Scanner scanner = new Scanner(System.in);

    List<Car> carList = new ArrayList<>(Arrays.asList());

    int key = 0;
    int index = 0;

    public void setReader() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            carList = mapper.readValue(new File("inventory.json"), new TypeReference<List<Car>>() {
            });

            carList.stream().forEach((car) -> {
                key++;
                index = key;
                System.out.println("+===========================================+");
                System.out.printf("[" + index + "]" + " " + car.getYear() + " " + car.getMake() + " " + car.getModel() + "%n");
                System.out.printf("Color:%s -- Mileage:%d%n", car.getColor(), car.getMileage());
            });
        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }

    public void setWriter() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String cars = mapper.writeValueAsString(carList);

            writer = new PrintWriter(new FileWriter("inventory.json"));
            writer.println(cars);

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
    }

    public void mainMenu() {
        System.out.println("+=====================================================================+");
        System.out.printf("[1]View All [2]Add Vehicle [3]Remove Vehicle [4]Filter Search [5]Exit%n");
        navigateMenu(Integer.parseInt(scanner.nextLine()));
    }

    public void navigateMenu(int userPick) {
        switch (userPick) {
            case 1:
                viewAll();
                break;
            case 2:
                addVehicle();
                break;
            case 3:
                removeVehicle();
                break;
            case 4:
                filterSearch();
                break;
            case 5:
                exitApp();
                break;
            default:
                System.out.println("Invalid menu option.");
        }
    }

    public void viewAll() {
        setReader();
        key = 0;
        mainMenu();
    }

    public void listAllForRemoval() {
        setReader();
        key = 0;
    }


    public void addVehicle() {
        System.out.printf("Please enter a make: %n");
        String make = scanner.nextLine();
        System.out.printf("Please enter a model: %n");
        String model = scanner.nextLine();
        System.out.printf("Please enter a year: %n");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.printf("Please enter a color: %n");
        String color = scanner.nextLine();
        System.out.printf("Please enter the current mileage: %n");
        int mileage = Integer.parseInt(scanner.nextLine());

        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);
        car.setColor(color);
        car.setMileage(mileage);

        carList.add(car);
        setWriter();
        System.out.printf("A %d %s %s with %d miles in the color %s has been added.%n", year, make, model, mileage, color);
        mainMenu();
    }

    public void removeVehicle() {
        listAllForRemoval();
        System.out.println("+===========================================+");
        System.out.printf("Please input the number of the vehicle you wish to remove.%n");
        int carNum = Integer.parseInt(scanner.nextLine()) - 1;

        carList.remove(carNum);
        System.out.printf("Car %d has been removed.%n", carNum + 1);
        setWriter();
        mainMenu();
    }


    public void filterSearch() {
        System.out.printf("Search by: [1]Make [2]Model [3]Year [4]Color [5]Mileage %n");
        int userPick = Integer.parseInt(scanner.nextLine());
        switch (userPick) {
            case 1:
                System.out.printf("Enter a make: %n");
                String userMake = scanner.nextLine();
                System.out.printf("+---------------Filtered by %s---------------+%n", userMake.toUpperCase());
                carList.stream().filter(c -> c.getMake().equalsIgnoreCase(userMake)).forEach(c -> {
                    System.out.printf(c.getYear() + " " + c.getMake() + " " + c.getModel() + "%n");
                    System.out.printf("Color:%s -- Mileage:%d%n", c.getColor(), c.getMileage());
                });
                break;
            case 2:
                System.out.printf("Enter a model: %n");
                String userModel = scanner.nextLine();
                System.out.printf("+---------------Filtered by %s---------------+%n", userModel.toUpperCase());
                carList.stream().filter(c -> c.getModel().equalsIgnoreCase(userModel)).forEach(c -> {
                    System.out.printf(c.getYear() + " " + c.getMake() + " " + c.getModel() + "%n");
                    System.out.printf("Color:%s -- Mileage:%d%n", c.getColor(), c.getMileage());
                });
                break;
            case 3:
                System.out.printf("Enter a year: %n");
                int userYear = Integer.parseInt(scanner.nextLine());
                System.out.printf("+---------------Filtered by %d---------------+%n", userYear);
                carList.stream().filter(c -> c.getYear() == userYear).forEach(c -> {
                    System.out.printf(c.getYear() + " " + c.getMake() + " " + c.getModel() + "%n");
                    System.out.printf("Color:%s -- Mileage:%d%n", c.getColor(), c.getMileage());
                });
                break;
            case 4:
                System.out.printf("Enter a color: %n");
                String userColor = scanner.nextLine();
                System.out.printf("+---------------Filtered by %s---------------+%n", userColor.toUpperCase());
                carList.stream().filter(c -> c.getColor().equalsIgnoreCase(userColor)).forEach(c -> {
                    System.out.printf(c.getYear() + " " + c.getMake() + " " + c.getModel() + "%n");
                    System.out.printf("Color:%s -- Mileage:%d%n", c.getColor(), c.getMileage());
                });
                break;
            case 5:
                System.out.printf("Enter a mileage: %n");
                int userMileage = Integer.parseInt(scanner.nextLine());
                System.out.printf("Enter a condition: [L]ess than or [M]ore than %n");
                String userCondition = scanner.nextLine();
                if (userCondition.equalsIgnoreCase("L")) {
                    System.out.printf("+---------------Filtered by %d---------------+%n", userMileage);
                    carList.stream().filter(c -> c.getMileage() < userMileage).forEach(c -> {
                        System.out.printf(c.getYear() + " " + c.getMake() + " " + c.getModel() + "%n");
                        System.out.printf("Color:%s -- Mileage:%d%n", c.getColor(), c.getMileage());
                        System.out.printf("----------------------------------%n");
                    });
                }
                if (userCondition.equalsIgnoreCase("M")) {
                    System.out.printf("+---------------Filtered by %d---------------+%n", userMileage);
                    carList.stream().filter(c -> c.getMileage() > userMileage).forEach(c -> {
                        System.out.printf(c.getYear() + " " + c.getMake() + " " + c.getModel() + "%n");
                        System.out.printf("Color:%s -- Mileage:%d%n", c.getColor(), c.getMileage());
                        System.out.printf("----------------------------------%n");
                    });
                }
                break;
        }
        mainMenu();
    }

    public void exitApp() {
        System.out.println("THANKS FOR USING THE CAR INVENTORY TRACKER. HAVE AN AWESOME DAY!");
        return;
    }
}
