package com.example.citiesstatesapi.model;

import javax.validation.constraints.*;

public class City {
    @NotEmpty(message="Must enter a city name.")
    @Size(min=2, max=60, message="Must contain more than 2 and less than 60 characters.")
    @Pattern(regexp="[A-Z, a-z]+", message="City name can only contain letter characters.")
    private String name;
    @NotEmpty(message="Must enter a state name.")
    @Size(min=2, max=2, message="Must enter a state with format XX")
    @Pattern(regexp="[A-Z, a-z]+", message="State name can only contain letter characters.")
    private String state;
    @Min(1)
    @Positive(message="Must have population more than 1.")
//    @Pattern(regexp="[0-9]+", message="Population must be a number.")
    private Integer population;
    private Boolean isStateCapital;

    public City() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state.toUpperCase();
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public Boolean getIsStateCapital() {
        return isStateCapital;
    }
    public void setIsStateCapital(Boolean isStateCapital) {
        this.isStateCapital = isStateCapital;
    }
}

