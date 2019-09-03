package com.company.SandyYeungU1Capstone.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {

    private int consoleId;
    @NotNull(message = "Model must not be null.")
    @Size(min = 2, max = 50)
    private String model;
    @Size(min = 2, max = 50)
    @NotNull(message = "Manufacturer must not be null.")
    private String manufacturer;
    @Size(min = 1, max = 20)
    private String memoryAmount;
    @Size(min = 1, max = 20)
    private String processor;
    @NotNull(message = "Price must not be null.")
    private BigDecimal price;
    @NotNull(message = "Quantity must not be null.")
    private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return getConsoleId() == console.getConsoleId() &&
                getQuantity() == console.getQuantity() &&
                getModel().equals(console.getModel()) &&
                getManufacturer().equals(console.getManufacturer()) &&
                getMemoryAmount().equals(console.getMemoryAmount()) &&
                getProcessor().equals(console.getProcessor()) &&
                getPrice().equals(console.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }

}


//    console_id int(11) not null auto_increment primary key,
//    model varchar(50) not null,
//    manufacturer varchar(50) not null,
//    memory_amount varchar(20),
//    processor varchar(20),
//    price decimal(5, 2) not null,
//    quantity int(11) not null