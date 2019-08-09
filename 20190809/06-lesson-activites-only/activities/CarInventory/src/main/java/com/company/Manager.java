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
    Scanner scanner = new Scanner(System.in);

    List<Car> carList = new ArrayList<>(Arrays.asList());
//    HashMap<Integer, ArrayList<Car> carList = new HashMap<Integer, ArrayList<Car>();

    int key = 0;
    int index = 0;

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
        carList.stream().forEach((car) -> {
            key++;
            index = key;
            System.out.println("+===========================================+");
            System.out.printf("[" + index + "]" + " " + car.getYear() + " " + car.getMake() + " " + car.getModel() + "%n");
            System.out.printf("Color:%s -- Mileage:%d%n", car.getColor(), car.getMileage());
//            index++;
        });
        key=0;
        mainMenu();
    }

    public void listAllForRemoval() {
        carList.stream().forEach(car -> {
            key++;
            index = key;
            System.out.println("+===========================================+");
            System.out.printf("[" + index + "]" + " " + car.getYear() + " " + car.getMake() + " " + car.getModel() + "%n");
            System.out.printf("Color:%s -- Mileage:%d%n", car.getColor(), car.getMileage());
        });
        key=0;
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
//        viewAll();
        System.out.printf("A %d %s %s with %d miles in the color %s has been added.%n", year, make, model, mileage, color);
        mainMenu();
    }

    public void removeVehicle() {
//        viewAll();
        listAllForRemoval();
        System.out.println("+===========================================+");
        System.out.printf("Please input the number of the vehicle you wish to remove.%n");
        int carNum = Integer.parseInt(scanner.nextLine())-1;

        Iterator iterator = carList.iterator();
        int count = 0;

        while(iterator.hasNext()) {
            iterator.next();
                if(count == carNum) {
                    iterator.remove();
                    System.out.printf("Removed car %d%n", carNum+1);
                    break;
                }
            count++;
        }
//        viewAll();
        listAllForRemoval();
        mainMenu();
    }

//    public void removeVehicle(Map<String, String> mapCars) {
//        for(Map.Entry<String, String> entry: mapCars.entrySet())
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//    }


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
