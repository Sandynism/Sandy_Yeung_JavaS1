package com.company.carinventoryjdbctemplatedao.dao;

import com.company.carinventoryjdbctemplatedao.model.Car;
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
public class CarInventoryDaoTest {

    @Autowired
    protected CarInventoryDao dao;

    //for each dao being tested, a new cleared list must be added.
    @Before
    public void setUp() throws Exception {
        List<Car> carList = dao.getAllCars();

        carList.stream()
                .forEach(car -> dao.deleteCar(car.getId()));
    }

    @Test
    public void getAllCars() {
        Car car = new Car();
        car.setMake("Ferrari");
        car.setModel("California");
        car.setYear("2018");
        car.setColor("Yellow");

        dao.addCar(car);

        car = new Car();
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2017");
        car.setColor("Silver");

        dao.addCar(car);

        List<Car> carList = dao.getAllCars();

        assertEquals(carList.size(), 2);
    }

    @Test
    public void addGetDeleteCar() {
        Car car = new Car();
        car.setMake("Ferrari");
        car.setModel("California");
        car.setYear("2018");
        car.setColor("Yellow");

        car = dao.addCar(car);

        Car car2 = dao.getCarById(car.getId());

        assertEquals(car, car2);

        dao.deleteCar(car.getId());

        car2 = dao.getCarById(car.getId());

        assertNull(car2);
    }

    @Test
    public void updateCar() {
        Car car = new Car();
        car.setMake("Ferrari");
        car.setModel("California");
        car.setYear("2018");
        car.setColor("Yellow");

        car = dao.addCar(car);

        car.setMake("Ferrari Updated");
        car.setModel("XL");
        car.setYear("2018");
        car.setColor("Yellow");

        dao.updateCar(car);

        Car car2 = dao.getCarById(car.getId());

        assertEquals(car, car2);
    }

    @Test
    public void getCarByMake() {
        Car car = new Car();
        car.setMake("Ferrari");
        car.setModel("California");
        car.setYear("2018");
        car.setColor("Yellow");

        dao.addCar(car);

        car.setMake("Ferrari");
        car.setModel("California");
        car.setYear("2002");
        car.setColor("Red");

        dao.addCar(car);

        List<Car> carList = dao.getCarByMake("Ferrari");
        assertEquals(carList.size(), 2);

        carList = dao.getCarByMake("Toyota");
        assertEquals(carList.size(), 0);
    }

    @Test
    public void getCarByColor() {
        Car car = new Car();
        car.setMake("Ferrari");
        car.setModel("California");
        car.setYear("2018");
        car.setColor("Yellow");

        dao.addCar(car);

        car.setMake("Ferrari");
        car.setModel("California");
        car.setYear("2002");
        car.setColor("Red");

        dao.addCar(car);

        List<Car> carList = dao.getCarByColor("Yellow");
        assertEquals(carList.size(), 1);

        carList = dao.getCarByColor("Red");
        assertEquals(carList.size(), 1);

        carList = dao.getCarByColor("Silver");
        assertEquals(carList.size(), 0);
    }
}