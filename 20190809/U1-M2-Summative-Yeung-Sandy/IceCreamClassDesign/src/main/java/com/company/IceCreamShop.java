package com.company;

public class IceCreamShop {
    String flavor;
    String coneType;
    int pricePerScoop, quantity;

    double dailySales;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoope(int pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getConeType() {
        return coneType;
    }

    public void setConeType(String coneType) {
        this.coneType = coneType;
    }

    public double getDailySales() {
        return dailySales;
    }

    public void setDailySales(double dailySales) {
        this.dailySales = dailySales;
    }
}

//The first class represents ice cream as it might be modeled in the point-of-sale system in an ice cream shop.
