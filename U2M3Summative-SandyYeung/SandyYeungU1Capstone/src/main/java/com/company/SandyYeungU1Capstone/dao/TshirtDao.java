package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Tshirt;

import java.util.List;

public interface TshirtDao {
    List<Tshirt> getAllTshirts();

    Tshirt getTshirt(int tshirtId);

    Tshirt addTshirt(Tshirt tshirt);

    void deleteTshirt(int tshirtId);

    void updateTshirt(Tshirt tshirt);

    List<Tshirt> getTshirtsByColor(String color);

    List<Tshirt> getTshirtsBySize(String size);
}
