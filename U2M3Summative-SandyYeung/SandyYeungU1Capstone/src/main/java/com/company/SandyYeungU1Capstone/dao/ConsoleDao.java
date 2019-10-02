package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    List<Console> getAllConsoles();

    Console getConsole(int consoleId);

    Console addConsole(Console console);

    void deleteConsole(int consoleId);

    void updateConsole(Console console);

    List<Console> getConsolesByManufacturer(String manufacturer);
}

