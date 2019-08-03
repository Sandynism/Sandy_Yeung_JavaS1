package com.company;

public class Main {
    public static void main(String[] args) {
        Customer aimee = new Customer();
        aimee.setFirstName("Aimee");
        aimee.setLastName("Choco");
        aimee.setEmail("123java@gmail.com");
        aimee.setPhoneNumber("7188889090");
        aimee.setRewardsMember(true);
        aimee.getBillingAddress();
    }
}
