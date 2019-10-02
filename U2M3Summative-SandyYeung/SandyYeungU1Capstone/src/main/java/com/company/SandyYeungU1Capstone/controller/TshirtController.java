package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.exception.NotFoundException;
import com.company.SandyYeungU1Capstone.service.InvoiceServiceLayer;
import com.company.SandyYeungU1Capstone.viewModel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TshirtController {
    @Autowired
    InvoiceServiceLayer invoiceService;

    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TshirtViewModel createTshirt(@RequestBody @Valid TshirtViewModel tshirt) {
        TshirtViewModel existing = invoiceService.findTshirt(tshirt.getTshirtId());
        if(existing != null)
            throw new IllegalArgumentException("Tshirt " + tshirt.getTshirtId() + " already exists!");
        invoiceService.saveTshirt(tshirt);
        return tshirt;
    }

    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getAllTshirts() {
        return invoiceService.findAllTshirts();
    }

    @RequestMapping(value = "/tshirt/{tshirtId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TshirtViewModel getTshirt(@PathVariable(name = "tshirtId") int tshirtId) {
        TshirtViewModel tshirt = invoiceService.findTshirt(tshirtId);
        if(tshirt == null)
            throw new NotFoundException("Tshirt could not be retrieved for id " + tshirtId);
        return tshirt;
    }

    @RequestMapping(value = "/tshirt/{tshirtId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable(name = "tshirtId") int tshirtId) {
        invoiceService.deleteTshirt(tshirtId);
    }

    @RequestMapping(value = "/tshirt/{tshirtId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTshirt(@RequestBody @Valid TshirtViewModel tshirt) {
        TshirtViewModel notExisting = invoiceService.findTshirt(tshirt.getTshirtId());
        if(notExisting == null)
            throw new IllegalArgumentException("Tshirt " + tshirt.getTshirtId() + " does not exist.");
        invoiceService.updateTshirt(tshirt);
    }

    @RequestMapping(value = "/tshirt/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getTshirtsByColor(@PathVariable(name = "color") String color) {
        List<TshirtViewModel> tshirts = invoiceService.getTshirtsByColor(color);
        if(tshirts != null && tshirts.size() == 0)
            throw new NotFoundException("Tshirts could not be found for " + color + " color");
        return tshirts;
    }

    @RequestMapping(value = "/tshirt/size/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getTshirtsBySize(@PathVariable(name = "size") String size) {
        List<TshirtViewModel> tshirts = invoiceService.getTshirtsBySize(size);
        if(tshirts != null && tshirts.size() == 0)
            throw new NotFoundException("Tshirts could not be found for size " + size);
        return tshirts;
    }

}

