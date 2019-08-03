package com.company;

public class IceCreamFactory {
    String flavor, customerName, customerAddress;
    int pricePerUnit, unitsInProduction, unitsSold, unitsAvailable;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getUnitsInProduction() {
        return unitsInProduction;
    }

    public void setUnitsInProduction(int unitsInProduction) {
        this.unitsInProduction = unitsInProduction;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public int getUnitsAvailable() {
        return unitsAvailable;
    }

    public void setUnitsAvailable(int unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
    }

}

//1. The second class represents ice cream as it might be modeled in an ice cream factory.