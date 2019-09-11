package com.sandy.sandyyeungrandomquoteservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
@RefreshScope
public class SandyYeungRandomQuoteServiceController {

    Random random = new Random();

    @Value("${quotes}")
    private String quotesList;

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String getQuote() {
        String[] quotes = quotesList.split("\\^");

        String quote = quotes[random.nextInt(quotes.length)];

        return quote;
    }
}
