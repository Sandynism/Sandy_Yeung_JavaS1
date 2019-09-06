package com.company.SandyYeungU1Capstone.viewModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class TshirtViewModel {
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
    @NotEmpty(message = "Price must not be empty.")
    private BigDecimal price;
    @NotEmpty(message = "Quantity must not be empty.")
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
        TshirtViewModel that = (TshirtViewModel) o;
        return getTshirtId() == that.getTshirtId() &&
                getQuantity() == that.getQuantity() &&
                getSize().equals(that.getSize()) &&
                getColor().equals(that.getColor()) &&
                getDescription().equals(that.getDescription()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTshirtId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

}
