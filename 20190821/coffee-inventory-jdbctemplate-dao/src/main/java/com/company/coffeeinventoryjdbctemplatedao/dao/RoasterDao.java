package com.company.coffeeinventoryjdbctemplatedao.dao;

import com.company.coffeeinventoryjdbctemplatedao.model.Roaster;

import java.util.List;

public interface RoasterDao {
    //find by id
    Roaster getRoaster(int roaster_id);
    //list all
    List<Roaster> getAllRoasters();
    //create a roaster
    Roaster addRoaster(Roaster roaster);
    //update a roaster
    void updateRoaster(Roaster roaster);
    //delete a roaster
    void deleteRoaster(int roaster_id);
}
