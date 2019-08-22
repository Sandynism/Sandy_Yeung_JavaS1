package com.company.carinventoryjdbctemplatedao.dao;

import com.company.carinventoryjdbctemplatedao.model.Car;

import java.util.List;

public interface CarInventoryDao {
    List<Car> getAllCars();

    Car getCarById(int id);

    Car addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int id);

    List <Car> getCarByMake(String make);

    List <Car> getCarByColor(String color);

}
