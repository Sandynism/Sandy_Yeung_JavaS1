package com.company.SandyYeungU1Capstone.viewModel;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Component
public class invoiceViewModel {
    private int invoiceId;
    @NotEmpty(message = "Name must not be empty.")
    @Size(min = 3, max = 80)
    private String name;
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
}
