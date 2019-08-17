package com.example.magic8ballapi.controller;

import com.example.magic8ballapi.model.Answer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8BallController {
    Random random = new Random();
    public List<Answer> answersList = new ArrayList<>();
    Answer randomAnswer;

    @RequestMapping(value="/magic", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Answer getAnswer(@RequestBody @Valid Answer question) {
        setReader();
        randomAnswer.setQuestion(question.getQuestion());
        System.out.println(randomAnswer.getAnswer());
        return randomAnswer;
    }

    public void setReader() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            answersList = mapper.readValue(new File("answersList.json"), new TypeReference<List<Answer>>() {
            });

            randomAnswer = answersList.get(random.nextInt(answersList.size()));
        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
