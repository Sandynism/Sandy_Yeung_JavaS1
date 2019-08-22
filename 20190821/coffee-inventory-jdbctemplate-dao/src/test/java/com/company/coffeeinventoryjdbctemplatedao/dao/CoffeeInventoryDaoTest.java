package com.company.coffeeinventoryjdbctemplatedao.dao;

import com.company.coffeeinventoryjdbctemplatedao.model.Coffee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CoffeeInventoryDaoTest {
    @Autowired
    protected CoffeeInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        List<Coffee> coffeeList = dao.getAllCoffees();

        coffeeList.stream()
                .forEach(coffee -> dao.deleteCoffee(coffee.getCoffeeId()));
    }

    @Test
    public void getAllCoffees() {
        Coffee coffee = new Coffee();
        coffee.setRoasterId(53);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        dao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(16);
        coffee.setName("Sumatra");
        coffee.setCount(100);
        coffee.setUnitPrice(8);
        coffee.setDescription("Dark Roast, Origin: Indonesia");
        coffee.setType("Arabica");

        dao.addCoffee(coffee);

        List<Coffee> coffeeList = dao.getAllCoffees();

        assertEquals(coffeeList.size(), 2);
    }

    @Test
    public void addGetDeleteCoffee() {
        Coffee coffee = new Coffee();
        coffee.setRoasterId(53);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        coffee = dao.addCoffee(coffee);

        Coffee coffee2 = dao.getCoffeeByCoffeeId(coffee.getCoffeeId());

        assertEquals(coffee2, coffee);

        dao.deleteCoffee(coffee.getCoffeeId());

        coffee2 = dao.getCoffeeByCoffeeId(coffee.getCoffeeId());

        assertNull(coffee2);
    }

    @Test
    public void updateCoffee() {

        Coffee coffee = new Coffee();
        coffee.setRoasterId(53);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        dao.addCoffee(coffee);

        coffee.setRoasterId(16);
        coffee.setName("New Sumatra");
        coffee.setCount(150);
        coffee.setUnitPrice(8);
        coffee.setDescription("Dark Roast, Origin: Indonesia");
        coffee.setType("Arabica");

        dao.updateCoffee(coffee);
        Coffee coffee2 = dao.getCoffeeByCoffeeId(coffee.getCoffeeId());
        assertEquals(coffee2, coffee);
    }

    @Test
    public void getCoffeeByType() {
        Coffee coffee = new Coffee();
        coffee.setRoasterId(53);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        dao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(16);
        coffee.setName("Sumatra");
        coffee.setCount(100);
        coffee.setUnitPrice(8);
        coffee.setDescription("Dark Roast, Origin: Indonesia");
        coffee.setType("Arabica");

        dao.addCoffee(coffee);

        List<Coffee> cList = dao.getCoffeeByType("Kona");
        assertEquals(cList.size(), 1);

        cList = dao.getCoffeeByType("Arabica");
        assertEquals(cList.size(), 1);

        cList = dao.getCoffeeByType("Noncoffee");
        assertEquals(cList.size(), 0);
    }



}