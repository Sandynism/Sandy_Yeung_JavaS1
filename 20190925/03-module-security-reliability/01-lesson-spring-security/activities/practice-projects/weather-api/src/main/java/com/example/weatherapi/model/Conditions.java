package com.example.weatherapi.model;

public class Conditions {
    public Integer fahrenheit;
    public Integer celsius;
    public Integer windSpeed;
    public String windDirection;
    public String skies;
    public String precipitation;

    public Conditions(Integer fahrenheit, Integer celsius, Integer windSpeed, String windDirection, String skies, String precipitation) {
        this.fahrenheit = fahrenheit;
        this.celsius = celsius;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.skies = skies;
        this.precipitation = precipitation;
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

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }


}


