package com.sandy.sandyyeungmagiceightballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class SandyYeungMagicEightBallServiceController {

    private List<String> answersList = new ArrayList<>();
    Random random = new Random();

    public SandyYeungMagicEightBallServiceController() {
        answersList.add("No");
        answersList.add("Yes");
        answersList.add("Looking cloudy");
        answersList.add("Not sure");
        answersList.add("Absolutely!");
        answersList.add("Ask again");
        answersList.add("Ummm");
        answersList.add("Not a chance");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getMagicEightBallAnswer() {
        String randomAnswer = answersList.get(random.nextInt(answersList.size()));
        return randomAnswer;
    }

}
