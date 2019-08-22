package com.company.coffeeinventoryjdbctemplatedao.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Roaster {
    private int roasterId;
    @NotEmpty(message="Must enter street.")
    private String street;
    @NotEmpty(message="Must enter city.")
    private String city;
    @NotEmpty(message="Must enter state.")
    private String state;
    @NotEmpty(message="Must enter postal code.")
    private String postalCode;
    @NotEmpty(message="Must enter phone.")
    private String phone;
    @NotEmpty(message="Must enter email.")
    private String email;
    @NotEmpty(message="Must enter note.")
    private String note;


    public int getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(int roasterId) {
        this.roasterId = roasterId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return getRoasterId() == roaster.getRoasterId() &&
                getStreet().equals(roaster.getStreet()) &&
                getCity().equals(roaster.getCity()) &&
                getState().equals(roaster.getState()) &&
                getPostalCode().equals(roaster.getPostalCode()) &&
                getPhone().equals(roaster.getPhone()) &&
                getEmail().equals(roaster.getEmail()) &&
                getNote().equals(roaster.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoasterId(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail(), getNote());
    }

}

//	roaster_id int not null auto_increment primary key,
//    name varchar(50) not null,
//    street varchar(50) not null,
//    city varchar(50) not null,
//    state char(2) not null,
//    postal_code varchar(25) not null,
//    phone varchar(15) not null,
//    email varchar(60) not null,
//    note varchar(255)