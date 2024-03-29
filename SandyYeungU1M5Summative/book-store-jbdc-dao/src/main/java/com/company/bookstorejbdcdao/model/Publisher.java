package com.company.bookstorejbdcdao.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Publisher {

    private int publisherId;
    @NotEmpty(message="Must have a name.")
    private String name;
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

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Publisher publisher = (Publisher) o;
        return getPublisherId() == publisher.getPublisherId() &&
                getName().equals(publisher.getName()) &&
                getStreet().equals(publisher.getStreet()) &&
                getCity().equals(publisher.getCity()) &&
                getState().equals(publisher.getState()) &&
                getPostalCode().equals(publisher.getPostalCode()) &&
                getPhone().equals(publisher.getPhone()) &&
                getEmail().equals(publisher.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisherId(), getName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail());
    }

}



//
///* Foreign Keys: book */
//alter table book add constraint fk_book_author foreign key (author_id) references author(author_id);
//alter table book add constraint fk_book_publisher foreign key (publisher_id) references publisher(publisher_id);