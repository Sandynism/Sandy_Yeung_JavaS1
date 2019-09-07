package com.company.SandyYeungU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {
    private int gameId;
    @NotEmpty(message = "Title must not be empty.")
    @Size(min = 1, max = 50)
    private String title;
    @NotEmpty(message = "Esrb rating must not be empty.")
    @Size(min = 1, max = 50)
    private String esrbRating;
    @NotEmpty(message = "Description must not be empty.")
    @Size(min = 3, max = 255)
    private String description;
    @Positive(message = "Price must be a positive amount.")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal price;
    @NotEmpty(message = "Studio must not be empty.")
    @Size(min = 1, max = 50)
    private String studio;
    @Min(1)
    private int quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        GameViewModel that = (GameViewModel) o;
        return getGameId() == that.getGameId() &&
                getQuantity() == that.getQuantity() &&
                getTitle().equals(that.getTitle()) &&
                getEsrbRating().equals(that.getEsrbRating()) &&
                getDescription().equals(that.getDescription()) &&
                getPrice().equals(that.getPrice()) &&
                getStudio().equals(that.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getTitle(), getEsrbRating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }


}
