package com.example.weatherapi.model;

public class Temperature {
    public Integer fahrenheit;
    public Integer celsius;

    public Temperature(int fahrenheit, int celsius) {
        this.fahrenheit = fahrenheit;
        this.celsius = celsius;
    }

    public Integer getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(Integer fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public Integer getCelsius() {
        return celsius;
    }

    public void setCelsius(Integer celsius) {
        this.celsius = celsius;
    }
}


