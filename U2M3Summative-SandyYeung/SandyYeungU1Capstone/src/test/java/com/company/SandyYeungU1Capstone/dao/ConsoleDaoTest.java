package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Console;
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
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consolesList = consoleDao.getAllConsoles();
        for(Console c : consolesList) {
            consoleDao.deleteConsole(c.getConsoleId());
        }
    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("512 MB");
        console.setProcessor("APU");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(8);

        consoleDao.addConsole(console);

        console = new Console();
        console.setModel("XBOX 360");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("512 MB");
        console.setProcessor("Triple Core Xenon");
        console.setPrice(new BigDecimal("310.99"));
        console.setQuantity(10);

        consoleDao.addConsole(console);

        List<Console> consolesList = consoleDao.getAllConsoles();
        assertEquals(consolesList.size(), 2);
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("512 MB");
        console.setProcessor("APU");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(8);

        consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console, console1);

        consoleDao.deleteConsole(console.getConsoleId());
        console1 = consoleDao.getConsole(console.getConsoleId());
        assertNull(console1);
    }


    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("16 GB");
        console.setProcessor("APU");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(8);

        consoleDao.addConsole(console);

        console.setModel("Playstation 4");
        console.setQuantity(10);

        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console, console1);
    }

    @Test
    public void getConsolesByManufacturer() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("512 MB");
        console.setProcessor("APU");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(8);

        consoleDao.addConsole(console);

        console = new Console();
        console.setModel("XBOX 360");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("512 MB");
        console.setProcessor("Triple Core Xenon");
        console.setPrice(new BigDecimal("310.99"));
        console.setQuantity(10);

        consoleDao.addConsole(console);

        List<Console> consolesList = consoleDao.getConsolesByManufacturer("Microsoft");
        assertEquals(consolesList.size(), 1);

        consolesList = consoleDao.getConsolesByManufacturer("Sony");
        assertEquals(consolesList.size(), 1);

        consolesList = consoleDao.getConsolesByManufacturer("Manufacturer");
        assertEquals(consolesList.size(), 0);
    }
}


//    console_id int(11) not null auto_increment primary key,
//    model varchar(50) not null,
//    manufacturer varchar(50) not null,
//    memory_amount varchar(20),
//    processor varchar(20),
//    price decimal(5, 2) not null,
//    quantity int(11) not null