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
public class RoasterDaoTest {

    @Autowired
    protected RoasterDao dao;

    @Autowired
    protected CoffeeInventoryDao dao2;

    @Before
    public void setUp() throws Exception {
        List<Coffee> coffeeList = dao2.getAllCoffees();

        coffeeList.stream()
                .forEach(coffee -> dao2.deleteCoffee(coffee.getCoffeeId()));

        List<Roaster> roasterList = dao.getAllRoasters();

        roasterList.stream()
                .forEach(roaster -> dao.deleteRoaster(roaster.getRoasterId()));
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

        roaster = dao.addRoaster(roaster);

        Roaster roaster2 = dao.getRoaster(roaster.getRoasterId());

        assertEquals(roaster, roaster2);

        dao.deleteRoaster(roaster.getRoasterId());

        roaster2 = dao.getRoaster(roaster.getRoasterId());

        assertNull(roaster2);
    }


    @Test
    public void getAllRoasters() {
        Roaster roaster = new Roaster();
        roaster.setName("Starbucks");
        roaster.setStreet("188th Street");
        roaster.setCity("Fresh Meadows");
        roaster.setState("NY");
        roaster.setPostalCode("11365");
        roaster.setPhone("8888888888");
        roaster.setEmail("starbucks@coffee.com");
        roaster.setNote("this location offers nitro coffee");

        dao.addRoaster(roaster);

        roaster = new Roaster();
        roaster.setName("Coffee Bean");
        roaster.setStreet("215th Street");
        roaster.setCity("Bayside");
        roaster.setState("NY");
        roaster.setPostalCode("11377");
        roaster.setPhone("1234567897");
        roaster.setEmail("starbuckssucks@coffee.com");
        roaster.setNote("this location has free wifi");

        dao.addRoaster(roaster);

        List<Roaster> roasterList = dao.getAllRoasters();

        assertEquals(roasterList.size(), 2);
    }


    @Test
    public void updateRoaster() {
        Roaster roaster = new Roaster();
        roaster.setName("Starbucks");
        roaster.setStreet("188th Street");
        roaster.setCity("Fresh Meadows");
        roaster.setState("NY");
        roaster.setPostalCode("11365");
        roaster.setPhone("8888888888");
        roaster.setEmail("starbucks@coffee.com");
        roaster.setNote("this location offers nitro coffee");

        dao.addRoaster(roaster);

        roaster.setName("Coffee Bean");
        roaster.setStreet("215th Street");
        roaster.setCity("Bayside");
        roaster.setState("NY");
        roaster.setPostalCode("11377");
        roaster.setPhone("1234567897");
        roaster.setEmail("starbuckssucks@coffee.com");
        roaster.setNote("this location has free wifi");

        dao.updateRoaster(roaster);
        Roaster roaster2 = dao.getRoaster(roaster.getRoasterId());
        assertEquals(roaster2, roaster);

    }


}