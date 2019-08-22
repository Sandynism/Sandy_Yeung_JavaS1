package com.company.coffeeinventoryjdbctemplatedao.dao;

import com.company.coffeeinventoryjdbctemplatedao.model.Coffee;

import java.util.List;

public interface CoffeeInventoryDao {
    //list all
    List<Coffee> getAllCoffees();
    //get a coffee by id
    Coffee getCoffeeByCoffeeId(int coffee_id);
    //create a coffee
    Coffee addCoffee(Coffee coffee);
    //update a coffee
    void updateCoffee(Coffee coffee);
    //delete a coffee
    void deleteCoffee(int coffee_id);
    //find coffees by type
    List<Coffee> getCoffeeByType(String type);
    //find coffee by roaster_id
    List<Coffee> getCoffeeByRoasterId(int roaster_id);
}
