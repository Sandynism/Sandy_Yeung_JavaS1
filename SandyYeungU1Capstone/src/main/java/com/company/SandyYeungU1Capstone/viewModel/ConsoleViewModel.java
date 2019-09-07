package com.company.SandyYeungU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {
    private int consoleId;
    @NotEmpty(message = "Model must not be empty.")
    @Size(min = 2, max = 50)
    private String model;
    @Size(min = 2, max = 50)
    @NotEmpty(message = "Manufacturer must not be empty.")
    private String manufacturer;
    @Size(min = 1, max = 20)
    private String memoryAmount;
    @Size(min = 1, max = 20)
    private String processor;
    @Positive(message = "Price must be a positive amount.")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal price;
    @Min(1)
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
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getConsoleId() == that.getConsoleId() &&
                getQuantity() == that.getQuantity() &&
                getModel().equals(that.getModel()) &&
                getManufacturer().equals(that.getManufacturer()) &&
                getMemoryAmount().equals(that.getMemoryAmount()) &&
                getProcessor().equals(that.getProcessor()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }
}
