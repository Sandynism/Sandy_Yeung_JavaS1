package com.company.coffeeinventoryjdbctemplatedao.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Coffee {
    private int coffeeId;
    private int roasterId;
    @NotEmpty(message="Must enter name.")
    private String name;
    @NotEmpty(message="Must enter count.")
    private int count;
    @NotEmpty(message ="Must enter unit price.")
    private double unitPrice;
    private String description;
    private String type;

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(int roasterId) {
        this.roasterId = roasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return getCoffeeId() == coffee.getCoffeeId() &&
                getRoasterId() == coffee.getRoasterId() &&
                getCount() == coffee.getCount() &&
                Double.compare(coffee.getUnitPrice(), getUnitPrice()) == 0 &&
                getName().equals(coffee.getName()) &&
                getDescription().equals(coffee.getDescription()) &&
                getType().equals(coffee.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoffeeId(), getRoasterId(), getName(), getCount(), getUnitPrice(), getDescription(), getType());
    }

}


//	coffee_id int not null auto_increment primary key,
//            roaster_id int not null,
//            name varchar(50) not null,
//            count int not null,
//            unit_price decimal(5,2) not null,
//            description varchar(255),
//            type varchar(50)
