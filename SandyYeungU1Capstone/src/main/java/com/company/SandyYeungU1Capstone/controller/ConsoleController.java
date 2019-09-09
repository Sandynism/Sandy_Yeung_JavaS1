package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.exception.NotFoundException;
import com.company.SandyYeungU1Capstone.service.InvoiceServiceLayer;
import com.company.SandyYeungU1Capstone.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    InvoiceServiceLayer invoiceService;

    @RequestMapping(value = "/consoles/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel console) {
        ConsoleViewModel existing = invoiceService.findConsole(console.getConsoleId());
        if (existing != null)
            throw new IllegalArgumentException("Console " + console.getConsoleId() + " already exists!");
        invoiceService.saveConsole(console);
        return console;
    }

    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        return invoiceService.findAllConsoles();
    }

    @RequestMapping(value = "/console/{consoleId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable(name = "consoleId") int consoleId) {
        ConsoleViewModel console = invoiceService.findConsole(consoleId);
        if (console == null)
            throw new NotFoundException("Console could not be retrieved for id " + consoleId);
        return console;
    }

    @RequestMapping(value = "/console/{consoleId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable(name = "consoleId") int consoleId) {
        invoiceService.deleteConsole(consoleId);
    }

    @RequestMapping(value = "/console/{consoleId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel console) {
        ConsoleViewModel notExisting = invoiceService.findConsole(console.getConsoleId());
        if(notExisting == null)
            throw new IllegalArgumentException("Console " + console.getConsoleId() + " does not exist.");
        invoiceService.updateConsole(console);
    }

    @RequestMapping(value = "/consolesManufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable(name = "manufacturer") String manufacturer) {
        List<ConsoleViewModel> consoles = invoiceService.getConsolesByManufacturer(manufacturer);
        if(consoles != null && consoles.size() == 0)
            throw new NotFoundException("Consoles could not be found for " + manufacturer);
        return consoles;
    }
}

