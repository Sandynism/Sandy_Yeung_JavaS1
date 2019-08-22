package com.company.carinventoryjdbctemplatedao.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Car {
    private int id;
    @NotEmpty(message="Must have a make.")
    private String make;
    @NotEmpty(message="Must have a model.")
    private String model;
    @NotEmpty(message="Must have a year.")
    @Size(min=4, max=4, message="Must be 4 numbers in length.")
    private String year;
    @NotEmpty(message="Must have a color.")
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId() == car.getId() &&
                getMake().equals(car.getMake()) &&
                getModel().equals(car.getModel()) &&
                getYear().equals(car.getYear()) &&
                getColor().equals(car.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(), getYear(), getColor());
    }

}

