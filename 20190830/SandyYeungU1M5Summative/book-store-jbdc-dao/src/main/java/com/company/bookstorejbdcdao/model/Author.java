package com.company.bookstorejbdcdao.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Author {

    private int authorId;
    @NotEmpty(message="Must have a first name.")
    private String firstName;
    @NotEmpty(message="Must have a last name.")
    private String lastName;
    @NotEmpty(message="Must have a street.")
    private String street;
    @NotEmpty(message="Must have a city.")
    private String city;
    @NotEmpty(message="Must have a state.")
    private String state;
    @NotEmpty(message="Must have a postal code.")
    private String postalCode;
    @NotEmpty(message="Must have a phone number.")
    private String phone;
    @NotEmpty(message="Must have an email address.")
    private String email;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getAuthorId() == author.getAuthorId() &&
                getFirstName().equals(author.getFirstName()) &&
                getLastName().equals(author.getLastName()) &&
                getStreet().equals(author.getStreet()) &&
                getCity().equals(author.getCity()) &&
                getState().equals(author.getState()) &&
                getPostalCode().equals(author.getPostalCode()) &&
                getPhone().equals(author.getPhone()) &&
                getEmail().equals(author.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getFirstName(), getLastName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail());
    }
}

