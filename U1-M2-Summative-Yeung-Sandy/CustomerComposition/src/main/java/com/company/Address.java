package com.company;

public class Address {
    private String street1, street2, city, state, zip;

    public Address(String street1, String street2, String city, String state, String zip) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    };

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }



}

//In this exercise, you will design and implement a class that represents a customer based on the specification below. Use composition for maximum code reuse.
//
//Create your solution in an IntelliJ project called ```CustomerComposition```.
//
//* Design a Customer class.
//* It must keep track of:
//  * First name
//  * Last name
//  * Email
//  * Phone number
//  * Shipping address:
//    * Street 1
//    * Street 2
//    * City
//    * State
//    * Zip
//  * Billing address:
//    * Street 1
//    * Street 2
//    * City
//    * State
//    * Zip
//  * If the customer is a Rewards Member or not.