package com.company.SandyYeungU1Capstone.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Tshirt {

    private int tshirtId;
    @NotEmpty(message = "Size must not be empty.")
    @Size(min = 1, max = 20)
    private String size;
    @NotEmpty(message = "Color must not be empty.")
    @Size(min = 1, max = 20)
    private String color;
    @NotEmpty(message = "Description must not be empty.")
    @Size(min = 3, max = 255)
    private String description;
    @Positive(message = "Price must be a positive amount.")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal price;
    @Min(1)
    private int quantity;

    public int getTshirtId() {
        return tshirtId;
    }

    public void setTshirtId(int tshirtId) {
        this.tshirtId = tshirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tshirt tshirt = (Tshirt) o;
        return getTshirtId() == tshirt.getTshirtId() &&
                getQuantity() == tshirt.getQuantity() &&
                getSize().equals(tshirt.getSize()) &&
                getColor().equals(tshirt.getColor()) &&
                getDescription().equals(tshirt.getDescription()) &&
                getPrice().equals(tshirt.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTshirtId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

}


//    t_shirt_id int(11) not null auto_increment primary key,
//    size varchar(20) not null,
//    color varchar(20) not null,
//    description varchar(255) not null,
//    price decimal(5,2) not null,
//    quantity int(11) not null