package com.example.dayconverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.security.Principal;

@RestController
public class DayConverterApplicationController {

    @Min(value = 1, message = "Must be value between 1 and 7.")
    @Max(value = 7, message = "Must be value between 1 and 7.")
    private int dayNumber;

    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String convertDay(@PathVariable int dayNumber, Principal principal) {
        if (dayNumber < 1 || dayNumber > 7) {
            throw new IllegalArgumentException("You must enter a whole number between 1 and 7");
        }
        String dayOfWeek = "";

        switch (dayNumber) {
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6:
                dayOfWeek = "Saturday";
                break;
            case 7:
                dayOfWeek = "Sunday";
                break;
        }
        return dayOfWeek;
    }

}
