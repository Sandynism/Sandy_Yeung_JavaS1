package com.trilogyed.shippingservice.viewModels;

import java.math.BigDecimal;

public class InvoiceItem {

    private Integer invoiceItemId;
    private Integer invoiceId;
    private String itemName;
    private String itemDescription;
    private Integer weight;
    private BigDecimal shipCost;

    public Integer getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getShipCost() {
        return shipCost;
    }

    public void setShipCost(BigDecimal shipCost) {
        this.shipCost = shipCost;
    }
}
