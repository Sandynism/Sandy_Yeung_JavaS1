package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.dao.TshirtDao;
import com.company.SandyYeungU1Capstone.model.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TshirtController {
    @Autowired
    TshirtDao tshirtDao;

    @RequestMapping(value = "/tshirts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Tshirt createTshirt(@RequestBody @Valid Tshirt tshirt) {
        tshirtDao.addTshirt(tshirt);
        return tshirt;
    }

    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getAllTshirts() {
        return tshirtDao.getAllTshirts();
    }

    @RequestMapping(value = "/tshirts/{tshirtId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable(name="tshirtId") int tshirtId) {
        return tshirtDao.getTshirt(tshirtId);
    }

    @RequestMapping(value = "/tshirts/{tshirtId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTshirt(@PathVariable(name="tshirtId") int tshirtId) {
        tshirtDao.deleteTshirt(tshirtId);
    }

    @RequestMapping(value = "/tshirts/{tshirtId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTshirt(@RequestBody @Valid Tshirt tshirt) {
        tshirtDao.updateTshirt(tshirt);
    }

    @RequestMapping(value = "/tshirts/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtsByColor(@PathVariable(name="color") String color) {
        return tshirtDao.getTshirtsByColor(color);
    }

    @RequestMapping(value = "/tshirts/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtsBySize(@PathVariable(name="size") String size) {
        return tshirtDao.getTshirtsBySize(size);
    }

}

