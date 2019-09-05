package com.company.SandyYeungU1Capstone.viewModel;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class TshirtViewModel {
    private int tshirtId;
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
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTshirtId(), getPrice(), getQuantity());
    }

}
