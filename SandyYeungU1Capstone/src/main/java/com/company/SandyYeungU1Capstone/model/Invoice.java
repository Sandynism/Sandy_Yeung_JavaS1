package com.company.SandyYeungU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {

    private int invoiceId;
    @NotEmpty(message = "Name must not be empty.")
    @Size(min = 3, max = 80)
    private String name;
    @NotEmpty(message = "Street must not be empty.")
    @Size(min = 1, max = 30)
    private String street;
    @NotEmpty(message = "City must not be empty.")
    @Size(min = 1, max = 30)
    private String city;
    @NotEmpty(message = "State must not be empty.")
    @Size(min = 1, max = 30)
    private String state;
    @NotEmpty(message = "Zipcode must not be empty.")
    @Size(min = 5, max = 5)
    private String zipcode;
    @NotEmpty(message = "Item type must not be empty.")
    @Size(min = 1, max = 20)
    private String itemType;
    @NotEmpty(message = "Item ID type must not be empty.")
    private int itemId;
    @NotEmpty(message = "Unit price must not be empty.")
    private BigDecimal unitPrice;
    @NotEmpty(message = "Quantity must not be empty.")
    private int quantity;
    @NotEmpty(message = "Subtotal must not be empty.")
    private BigDecimal subtotal;
    @NotEmpty(message = "Tax must not be empty.")
    private BigDecimal tax;
    @NotEmpty(message = "Processing fee must not be empty.")
    private BigDecimal processingFee;
    @NotEmpty(message = "Total must not be empty.")
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                getItemId() == invoice.getItemId() &&
                getQuantity() == invoice.getQuantity() &&
                getName().equals(invoice.getName()) &&
                getStreet().equals(invoice.getStreet()) &&
                getCity().equals(invoice.getCity()) &&
                getState().equals(invoice.getState()) &&
                getZipcode().equals(invoice.getZipcode()) &&
                getItemType().equals(invoice.getItemType()) &&
                getUnitPrice().equals(invoice.getUnitPrice()) &&
                getSubtotal().equals(invoice.getSubtotal()) &&
                getTax().equals(invoice.getTax()) &&
                getProcessingFee().equals(invoice.getProcessingFee()) &&
                getTotal().equals(invoice.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getUnitPrice(), getQuantity(), getSubtotal(), getTax(), getProcessingFee(), getTotal());
    }

}

//    invoice_id int(11) not null auto_increment primary key,
//    name varchar(80) not null,
//    street varchar(30) not null,
//    city varchar(30) not null,
//    state varchar(30) not null,
//    zipcode varchar(5) not null,
//    item_type varchar(20) not null,
//    item_id int(11) not null,
//    unit_price decimal(5,2) not null,
//    quantity int(11) not null,
//    subtotal decimal(5,2) not null,
//    tax decimal(5,2) not null,
//    processing_fee decimal (5,2) not null,
//    total decimal(5,2) not null

//User Request Body
//	       1. Name
//	       1. Street
//	       1. City
//	       1. State
//	       1. Zip
//	       1. Item Type
//	       1. Item ID
//	       1. Quantity