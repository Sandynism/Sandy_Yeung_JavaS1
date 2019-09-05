package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.model.Tshirt;
import com.company.SandyYeungU1Capstone.service.InvoiceServiceLayer;
import com.company.SandyYeungU1Capstone.viewModel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/tshirts")
public class TshirtController {
    @Autowired
    InvoiceServiceLayer invoiceService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TshirtViewModel createTshirt(@RequestBody @Valid TshirtViewModel tshirt) {
        invoiceService.saveTshirt(tshirt);
        return tshirt;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getAllTshirts() {
        return invoiceService.findAllTshirts();
    }

    @GetMapping(value ="/{tshirtId}")
    @ResponseStatus(value = HttpStatus.OK)
    public TshirtViewModel getTshirt(@PathVariable(name="tshirtId") int tshirtId) {
        return invoiceService.findTshirt(tshirtId);
    }

    @DeleteMapping(value = "/{tshirtId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTshirt(@PathVariable(name="tshirtId") int tshirtId) {
        invoiceService.deleteTshirt(tshirtId);
    }

    @PutMapping(value = "/{tshirtId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTshirt(@RequestBody @Valid TshirtViewModel tshirt) {
        invoiceService.updateTshirt(tshirt);
    }

    @GetMapping(value = "/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getTshirtsByColor(@PathVariable(name="color") String color) {
        return invoiceService.getTshirtsByColor(color);
    }

    @GetMapping(value = "/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TshirtViewModel> getTshirtsBySize(@PathVariable(name="size") String size) {
        return invoiceService.getTshirtsBySize(size);
    }

}

