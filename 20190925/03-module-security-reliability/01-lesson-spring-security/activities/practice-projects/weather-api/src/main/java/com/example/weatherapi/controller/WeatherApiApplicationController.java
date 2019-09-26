package com.example.weatherapi.controller;

import com.example.weatherapi.model.Conditions;
import com.example.weatherapi.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.security.Principal;

@RestController
public class WeatherApiApplicationController extends HttpServlet {

    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Temperature getTemperature(String zipcode, Principal principal) {
        Temperature tempObject = new Temperature(99, 70);
        return tempObject;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Conditions getConditions(String zipcode, Principal principal) {
        Conditions conditionsObject = new Conditions(99, 70, 7, "Southwest", "cloudy", "light showers");
        return conditionsObject;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Principal principal) {

        return "Hello " + principal.getName() + "!!!";
    }

//    @WebServlet("/zipcodeServlet")
//    public String getZipcode(HttpServlet request) {
//        String zipcode = request.getParameter();
//        return zipcode;
//    }
}
