package com.company.SandyYeungU1Capstone.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesTaxRate {

    @NotNull(message = "State must not be null.")
    @Size(min=2, max=2, message = "State must be in ## format.")
    private char state;
    @NotNull(message = "Rate must not be null.")
    private BigDecimal rate;

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRate that = (SalesTaxRate) o;
        return getState() == that.getState() &&
                getRate().equals(that.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }

}

//    state char(2) not null,
//    rate decimal(3,2) not null