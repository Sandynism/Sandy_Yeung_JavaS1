package com.company.coffeeinventoryjdbctemplatedao.dao;

import com.company.coffeeinventoryjdbctemplatedao.model.Coffee;
import com.company.coffeeinventoryjdbctemplatedao.model.Roaster;
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

    @Autowired
    protected RoasterDao dao2;

    @Before
    public void setUp() throws Exception {
        List<Coffee> coffeeList = dao.getAllCoffees();

        coffeeList.stream()
                .forEach(coffee -> dao.deleteCoffee(coffee.getCoffeeId()));

        List<Roaster> roasterList = dao2.getAllRoasters();

        roasterList.stream()
                .forEach(roaster -> dao2.deleteRoaster(roaster.getRoasterId()));
    }

    @Test
    public void getAllCoffees() {
        Roaster roaster = new Roaster();
        roaster.setName("Starbucks");
        roaster.setStreet("188th Street");
        roaster.setCity("Fresh Meadows");
        roaster.setState("NY");
        roaster.setPostalCode("11365");
        roaster.setPhone("8888888888");
        roaster.setEmail("starbucks@coffee.com");
        roaster.setNote("this location offers nitro coffee");

        dao2.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(1);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        dao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(1);
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
        Roaster roaster = new Roaster();
        roaster.setName("Starbucks");
        roaster.setStreet("188th Street");
        roaster.setCity("Fresh Meadows");
        roaster.setState("NY");
        roaster.setPostalCode("11365");
        roaster.setPhone("8888888888");
        roaster.setEmail("starbucks@coffee.com");
        roaster.setNote("this location offers nitro coffee");

        dao2.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(1);
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
        Roaster roaster = new Roaster();
        roaster.setName("Starbucks");
        roaster.setStreet("188th Street");
        roaster.setCity("Fresh Meadows");
        roaster.setState("NY");
        roaster.setPostalCode("11365");
        roaster.setPhone("8888888888");
        roaster.setEmail("starbucks@coffee.com");
        roaster.setNote("this location offers nitro coffee");

        dao2.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(1);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        dao.addCoffee(coffee);

        coffee.setRoasterId(1);
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
        Roaster roaster = new Roaster();
        roaster.setName("Starbucks");
        roaster.setStreet("188th Street");
        roaster.setCity("Fresh Meadows");
        roaster.setState("NY");
        roaster.setPostalCode("11365");
        roaster.setPhone("8888888888");
        roaster.setEmail("starbucks@coffee.com");
        roaster.setNote("this location offers nitro coffee");

        dao2.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(1);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        dao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(1);
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

    @Test
    public void getCoffeeByRoasterId() {
        Roaster roaster = new Roaster();
        roaster.setName("Starbucks");
        roaster.setStreet("188th Street");
        roaster.setCity("Fresh Meadows");
        roaster.setState("NY");
        roaster.setPostalCode("11365");
        roaster.setPhone("8888888888");
        roaster.setEmail("starbucks@coffee.com");
        roaster.setNote("this location offers nitro coffee");

        dao2.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(1);
        coffee.setName("Koa");
        coffee.setCount(10);
        coffee.setUnitPrice(8);
        coffee.setDescription("Medium to Dark Roast, Origin: Hawaii");
        coffee.setType("Kona");

        dao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(1);
        coffee.setName("Sumatra");
        coffee.setCount(100);
        coffee.setUnitPrice(8);
        coffee.setDescription("Dark Roast, Origin: Indonesia");
        coffee.setType("Arabica");

        dao.addCoffee(coffee);

        List<Coffee> cList = dao.getCoffeeByRoasterId(1);
        assertEquals(cList.size(), 2);

        cList = dao.getCoffeeByRoasterId(16);
        assertEquals(cList.size(), 0);

        cList = dao.getCoffeeByRoasterId(8);
        assertEquals(cList.size(), 0);
    }


}