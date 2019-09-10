package com.example.wordapi.controller;

import com.example.wordapi.model.Definition;
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
public class WordApiController {
    Random random = new Random();
    List<Definition> wordsList = new ArrayList<>();
    Definition randomWord;

    @RequestMapping(value="/word", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Definition getDefinition(){
        setReader();
        System.out.printf("%s means '%s'%n", randomWord.getWord(), randomWord.getDefinition());
        return randomWord;
    }

    public void setReader() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            wordsList = mapper.readValue(new File("wordsList.json"), new TypeReference<List<Definition>>() {
            });

            randomWord = wordsList.get(random.nextInt(wordsList.size()));

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
