package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {
    List<SalesTaxRate> getAllSalesTaxRates();

    SalesTaxRate getSalesTaxRate(String state);

    SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate);

    void deleteSalesTaxRate(String state);

    void updateSalesTaxRate(SalesTaxRate salesTaxRate);
}
