package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.dao.ConsoleDao;
import com.company.SandyYeungU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    ConsoleDao consoleDao;

    @RequestMapping(value = "/consoles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {
        consoleDao.addConsole(console);
        return console;
    }

    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable(name="consoleId") int consoleId) {
        return consoleDao.getConsole(consoleId);
    }

    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteConsole(@PathVariable(name="consoleId") int consoleId) {
        consoleDao.deleteConsole(consoleId);
    }

    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateConsole(@RequestBody @Valid Console console) {
        consoleDao.updateConsole(console);
    }

    @RequestMapping(value = "/consoles/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable(name="manufacturer") String manufacturer) {
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }
}
