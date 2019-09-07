package com.company.SandyYeungU1Capstone.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {

    @NotEmpty(message = "Product type must not be empty.")
    @Size(min=1, max=20)
    private String productType;
    @Positive(message = "Processing fee must be a positive amount.")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return getProductType().equals(that.getProductType()) &&
                getFee().equals(that.getFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductType(), getFee());
    }

}


//    product_type varchar(20) not null,
//    fee decimal (4,2)