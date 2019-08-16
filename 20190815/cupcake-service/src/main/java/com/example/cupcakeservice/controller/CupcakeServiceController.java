package com.example.cupcakeservice.controller;

import com.example.cupcakeservice.model.Cupcake;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class CupcakeServiceController {

    @RequestMapping(value = "/cupcakes", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cupcake createCupcake(@RequestBody @Valid Cupcake cupcake) {
        Random random = new Random();
        cupcake.setId(random.nextInt(9999));

        if (cupcake.flavor.equals("") || cupcake.frostingType.equals("")) {
            throw new IllegalArgumentException("Empty string is not allowed.");
        }

        return cupcake;
    }

    @RequestMapping(value = "/cupcakes/{cakeId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Cupcake getCupcake(@PathVariable int cakeId) {
        Cupcake cupcake = new Cupcake();
        cupcake.setId(cakeId);
        cupcake.setFlavor("banana");
        cupcake.setFrostingType("jelly");

//        String message = "Wow! This cupcake is for me?!";
        return cupcake;
    }
}
