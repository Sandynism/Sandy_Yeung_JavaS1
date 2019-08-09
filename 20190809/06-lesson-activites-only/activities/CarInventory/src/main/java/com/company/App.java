package com.company;

public class App extends Manager {
    public static void main(String[] args) {
        Manager manager = new Manager();

        //manually inputting dummy cars
//        Car car1 = new Car();
//        car1.setMake("Toyota");
//        car1.setModel("Camry");
//        car1.setYear(2012);
//        car1.setColor("Blue");
//        car1.setMileage(15000);
//
//        Car car2 = new Car();
//        car2.setMake("Honda");
//        car2.setModel("Civic");
//        car2.setYear(2001);
//        car2.setColor("Silver");
//        car2.setMileage(90756);
//
//        Car car3 = new Car();
//        car3.setMake("Jeep");
//        car3.setModel("Wrangler");
//        car3.setYear(2009);
//        car3.setColor("White");
//        car3.setMileage(33888);
//
//        Car car4 = new Car();
//        car4.setMake("Tesla");
//        car4.setModel("Roadster");
//        car4.setYear(2018);
//        car4.setColor("Black");
//        car4.setMileage(8955);
//
//        Car car5 = new Car();
//        car5.setMake("Ford");
//        car5.setModel("Mustang");
//        car5.setYear(1964);
//        car5.setColor("Red");
//        car5.setMileage(200000);
//
//        Car car6 = new Car();
//        car6.setMake("Ford");
//        car6.setModel("Mustang");
//        car6.setYear(2019);
//        car6.setColor("Pink");
//        car6.setMileage(200);
//
//        Car car7 = new Car();
//        car7.setMake("Ferrari");
//        car7.setModel("California");
//        car7.setYear(2019);
//        car7.setColor("Yellow");
//        car7.setMileage(80);
//
//        manager.carList.add(car1);
//        manager.carList.add(car2);
//        manager.carList.add(car3);
//        manager.carList.add(car4);
//        manager.carList.add(car5);
//        manager.carList.add(car6);
//        manager.carList.add(car7);

        //app starts here
        System.out.printf("Hello! Welcome to the car inventory tracker. Please make a selection: %n");
        manager.mainMenu();

    }
}
