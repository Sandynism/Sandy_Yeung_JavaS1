package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.SalesTaxRate;
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
public class SalesTaxRateDaoTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() throws Exception {
        List<SalesTaxRate> salesTaxRatesList = salesTaxRateDao.getAllSalesTaxRates();
        for(SalesTaxRate s: salesTaxRatesList) {
            salesTaxRateDao.deleteSalesTaxRate(s.getState());
        }
    }

    @Test
    public void getAllSalesTaxRates() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal("0.06"));

        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("CA");
        salesTaxRate.setRate(new BigDecimal("0.06"));

        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        List<SalesTaxRate> salesTaxRatesList = salesTaxRateDao.getAllSalesTaxRates();
        assertEquals(salesTaxRatesList.size(), 2);
    }

    @Test
    public void addGetDeleteSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal("0.06"));

        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertEquals(salesTaxRate, salesTaxRate1);

        salesTaxRateDao.deleteSalesTaxRate(salesTaxRate.getState());
        salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertNull(salesTaxRate1);
    }


    @Test
    public void updateSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal("0.06"));

        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setRate(new BigDecimal("0.07"));

        salesTaxRateDao.updateSalesTaxRate(salesTaxRate);
        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertEquals(salesTaxRate, salesTaxRate1);
    }
}

//    state char(2) not null,
//    rate decimal(3,2) not null