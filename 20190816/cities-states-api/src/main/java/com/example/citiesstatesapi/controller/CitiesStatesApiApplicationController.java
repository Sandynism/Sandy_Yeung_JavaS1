package com.example.citiesstatesapi.controller;

import com.example.citiesstatesapi.model.City;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CitiesStatesApiApplicationController {
    PrintWriter writer = null;
    private List<City> citiesList = new ArrayList<>();

    @RequestMapping(value="/city", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public City addCity(@RequestBody @Valid City city) {
        city.setState(city.getState());
        citiesList.add(city);
        setWriter();
        return city;
    }

    @RequestMapping(value="/city", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<City> retrieveAllCities() {
        setReader();
        return citiesList;
    }

    @RequestMapping(value="/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable String name) {
        for(City city: citiesList) {
            if(city.getName().equalsIgnoreCase(name)) {
                citiesList.remove(city);
            }
        }
        setWriter();
        return;
    }

    @RequestMapping(value="/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public City retrieveCity(@PathVariable String name) {
        name = name.replaceAll("\\s","");

        for(City city: citiesList)    {
            if(city.getName().replaceAll("\\s","").equalsIgnoreCase(name)) {
                return city;
            }
        }
        throw new IllegalArgumentException("City cannot be found.");
    }


    public void setReader() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            citiesList = mapper.readValue(new File("citiesList.json"), new TypeReference<List<City>>() {
            });

            citiesList.stream().forEach((city) -> {
                System.out.println("+===========================================+");
                System.out.printf(city.getName() + " " + city.getState() + " " + city.getPopulation() + " " + city.getIsStateCapital() + "%n");
            });
        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }

    public void setWriter() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String city = mapper.writeValueAsString(citiesList);

            writer = new PrintWriter(new FileWriter("citiesList.json"));
            writer.println(city);

        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
