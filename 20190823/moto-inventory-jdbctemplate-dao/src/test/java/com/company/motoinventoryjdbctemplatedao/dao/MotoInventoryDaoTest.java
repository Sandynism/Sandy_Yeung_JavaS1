package com.company.motoinventoryjdbctemplatedao.dao;

import com.company.motoinventoryjdbctemplatedao.model.Motorcycle;
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
public class MotoInventoryDaoTest {

    @Autowired
    protected MotoInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        // clears out the test database
        List<Motorcycle> mList = dao.getAllMotorcycles();

        mList.stream()
                .forEach(motorcycle -> dao.deleteMotorcycle(motorcycle.getId()));
    }

    @Test
    public void addGetDeleteMotorcycle() {

        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        //database returns moto object back with the id*** id doesn't exist until dao sends it back.
        moto = dao.addMotorcycle(moto);

        //retrieving a motorcycle from database using the id, setting it to moto2.
        Motorcycle moto2 = dao.getMotorcycle(moto.getId());

        //checking to see if both objects are the same.
        assertEquals(moto, moto2);

        //deleting the test motorcycle.
        dao.deleteMotorcycle(moto.getId());

        //retrieving a motorcycle to see if the delete worked.
        moto2 = dao.getMotorcycle(moto.getId());

        //the test passes if it returns null. otherwise, delete did not work.
        assertNull(moto2);
    }

    @Test
    public void getAllMotorcycles() {
        Motorcycle moto = new Motorcycle();
        moto.setVin("98765");
        moto.setMake("Ferrari");
        moto.setModel("California");
        moto.setYear("2019");
        moto.setColor("Yellow");

        dao.addMotorcycle(moto);

        moto = new Motorcycle();
        moto.setVin("98885");
        moto.setMake("Lamborghini");
        moto.setModel("Murcielago");
        moto.setYear("2017");
        moto.setColor("Orange");

        dao.addMotorcycle(moto);

        List<Motorcycle> motoList = dao.getAllMotorcycles();

        //checks to make sure list has 2 items
        assertEquals(motoList.size(), 2);
    }

    @Test
    public void getMotorcyclesByMake() {
        Motorcycle moto = new Motorcycle();
        moto.setVin("22222");
        moto.setMake("Honda");
        moto.setModel("CB300");
        moto.setYear("2019");
        moto.setColor("red");

        dao.addMotorcycle(moto);

        moto = new Motorcycle();
        moto.setVin("33333");
        moto.setMake("Suzuki");
        moto.setModel("DR650");
        moto.setYear("2012");
        moto.setColor("gray");

        dao.addMotorcycle(moto);

        moto = new Motorcycle();
        moto.setVin("44444");
        moto.setMake("Suzuki");
        moto.setModel("DRZ 400");
        moto.setYear("2016");
        moto.setColor("black");

        dao.addMotorcycle(moto);

        //run three separate instances to check if it finds the suzuki, honda and one that does not exist.
        List<Motorcycle> mList = dao.getMotorcyclesByMake("Suzuki");
        assertEquals(mList.size(), 2);

        mList = dao.getMotorcyclesByMake("Honda");
        assertEquals(mList.size(), 1);

        mList = dao.getMotorcyclesByMake("Ducati");
        assertEquals(mList.size(), 0);

    }

    @Test
    public void updateMotorcycle() {

        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        moto = dao.addMotorcycle(moto);

        moto.setVin("99999");
        moto.setMake("UPDATED");
        moto.setModel("NEW MODEL");
        moto.setYear("1111");
        moto.setColor("NEW COLOR");

        dao.updateMotorcycle(moto);

        Motorcycle moto2 = dao.getMotorcycle(moto.getId());

        assertEquals(moto2, moto);
    }

}
