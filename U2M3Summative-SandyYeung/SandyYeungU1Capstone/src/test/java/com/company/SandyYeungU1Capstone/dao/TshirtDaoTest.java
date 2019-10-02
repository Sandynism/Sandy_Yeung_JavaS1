package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Tshirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtDaoTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {
        List<Tshirt> tshirtsList = tshirtDao.getAllTshirts();
        for(Tshirt t : tshirtsList) {
            tshirtDao.deleteTshirt(t.getTshirtId());
        }
    }

    @Test
    public void getAllTshirts() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirtDao.addTshirt(tshirt);

        tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Black");
        tshirt.setDescription("Polyester");
        tshirt.setPrice(new BigDecimal("5.99"));
        tshirt.setQuantity(100);

        tshirtDao.addTshirt(tshirt);

        List<Tshirt> tshirtsList = tshirtDao.getAllTshirts();
        assertEquals(tshirtsList.size(), 2);
    }

    @Test
    public void addGetDeleteTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.getTshirtId());
        assertEquals(tshirt, tshirt1);

        tshirtDao.deleteTshirt(tshirt.getTshirtId());
        tshirt1 = tshirtDao.getTshirt(tshirt.getTshirtId());
        assertNull(tshirt1);
    }


    @Test
    public void updateTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirtDao.addTshirt(tshirt);

        tshirt.setPrice(new BigDecimal("10.99"));
        tshirt.setQuantity(100);

        tshirtDao.updateTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.getTshirtId());
        assertEquals(tshirt, tshirt1);
    }

    @Test
    public void getTshirtsByColor() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirtDao.addTshirt(tshirt);

        tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Black");
        tshirt.setDescription("Polyester");
        tshirt.setPrice(new BigDecimal("5.99"));
        tshirt.setQuantity(100);

        tshirtDao.addTshirt(tshirt);

        List<Tshirt> tshirtsList = tshirtDao.getTshirtsByColor("White");
        assertEquals(tshirtsList.size(), 1);

        tshirtsList = tshirtDao.getTshirtsByColor("Pink");
        assertEquals(tshirtsList.size(), 0);
    }

    @Test
    public void getTshirtsBySize() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirtDao.addTshirt(tshirt);

        tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Black");
        tshirt.setDescription("Polyester");
        tshirt.setPrice(new BigDecimal("5.99"));
        tshirt.setQuantity(100);

        tshirtDao.addTshirt(tshirt);

        List<Tshirt> tshirtsList = tshirtDao.getTshirtsBySize("Medium");
        assertEquals(tshirtsList.size(), 1);

        tshirtsList = tshirtDao.getTshirtsBySize("Extra Small");
        assertEquals(tshirtsList.size(), 0);
    }
}

//    t_shirt_id int(11) not null auto_increment primary key,
//    size varchar(20) not null,
//    color varchar(20) not null,
//    description varchar(255) not null,
//    price decimal(5,2) not null,
//    quantity int(11) not null