package com.company.motoinventoryjdbctemplatedao.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Motorcycle {
    private int id;
    @NotEmpty(message = "Must enter vin.")
    private String vin;
    @NotEmpty(message = "Must enter make.")
    private String make;
    @NotEmpty(message = "Must enter model.")
    private String model;
    @NotEmpty(message = "Must enter year.")
    @Size(min = 4, max = 4, message = "Must be 4 values.")
    private String year;
    @NotEmpty(message = "Must enter color.")
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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
        Motorcycle that = (Motorcycle) o;
        return getId() == that.getId() &&
                getVin().equals(that.getVin()) &&
                getMake().equals(that.getMake()) &&
                getModel().equals(that.getModel()) &&
                getYear().equals(that.getYear()) &&
                getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVin(), getMake(), getModel(), getYear(), getColor());
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Motorcycle that = (Motorcycle) o;
//        return getId() == that.getId() &&
//                Objects.equals(getVin(), that.getVin()) &&
//                Objects.equals(getMake(), that.getMake()) &&
//                Objects.equals(getModel(), that.getModel()) &&
//                Objects.equals(getYear(), that.getYear()) &&
//                Objects.equals(getColor(), that.getColor());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getVin(), getMake(), getModel(), getYear(), getColor());
//    }


}
