package com.example.quoteapi.controller;

import com.example.quoteapi.model.Quote;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteApiController {
    Random random = new Random();
    public List<Quote> quotesList = new ArrayList<>();
    Quote randomQuote;

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getQuote() {
        setReader();
        System.out.printf("%s --- %s%n", randomQuote.getQuote(), randomQuote.getAuthor());
        return randomQuote;
    }

    public void setReader() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            quotesList = mapper.readValue(new File("quotesList.json"), new TypeReference<List<Quote>>() {
            });

            randomQuote = quotesList.get(random.nextInt(quotesList.size()));

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }

}

