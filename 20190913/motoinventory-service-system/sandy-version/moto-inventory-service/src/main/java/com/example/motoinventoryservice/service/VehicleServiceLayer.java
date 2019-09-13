package com.example.motoinventoryservice.service;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;
import com.example.motoinventoryservice.viewModel.VehicleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleServiceLayer {
    private int id;
    @NotEmpty(message = "You must supply a value for VIN.")
    @Size(min = 5, max = 5, message = "VIN must be 5 characters in length.")
    private String vin;
    @NotEmpty(message = "You must supply a value for make.")
    private String make;
    @NotEmpty(message = "You must supply a value for model.")
    private String model;
    @NotEmpty(message = "You must supply a value for year.")
    @Size(min = 4, max = 4, message = "Year must be 4 digits.")
    private String year;
    @NotEmpty(message = "You must supply a value for color.")
    private String color;

    MotoInventoryDao motoInventoryDao;

    @Autowired
    public VehicleServiceLayer(MotoInventoryDao motoInventoryDao) {
        this.motoInventoryDao = motoInventoryDao;
    }

    @Transactional
    public VehicleViewModel saveMotorcycle(VehicleViewModel vvm) {
        Motorcycle moto = new Motorcycle();
        moto.setVin(vvm.getVin());
        moto.setMake(vvm.getMake());
        moto.setModel(vvm.getModel());
        moto.setYear(vvm.getYear());
        moto.setColor(vvm.getColor());

        moto = motoInventoryDao.addMotorcycle(moto);

        vvm.setId(moto.getId());
        vvm.setVin(moto.getVin());
        vvm.setMake(moto.getMake());
        vvm.setModel(moto.getModel());
        vvm.setYear(moto.getYear());
        vvm.setColor(moto.getColor());

        return vvm;
    }

    public List<VehicleViewModel> findAllMotorcycles() {
        List<Motorcycle> motorcycleList = motoInventoryDao.getAllMotorcycles();
        List<VehicleViewModel> vvmList = new ArrayList<>();

        for (Motorcycle m : motorcycleList) {
            vvmList.add(buildVehicleViewModel(m));
        }
        return vvmList;
    }

    public VehicleViewModel findMotorcycle(int id) {
        Motorcycle moto = motoInventoryDao.getMotorcycle(id);
        if (moto == null)
            return null;
        else return buildVehicleViewModel(moto);
    }

    public void deleteMotorcycle(int id) {
        motoInventoryDao.deleteMotorcycle(id);
    }

    public void updateMotorcycle(VehicleViewModel vvm) {
        Motorcycle moto = new Motorcycle();
        moto.setId(vvm.getId());
        moto.setVin(vvm.getVin());
        moto.setMake(vvm.getMake());
        moto.setModel(vvm.getModel());
        moto.setYear(vvm.getYear());
        moto.setColor(vvm.getColor());
        motoInventoryDao.updateMotorcycle(moto);
    }

    public List<VehicleViewModel> findMotorcyclesByMake(String make) {
        List<Motorcycle> motorcycleList = motoInventoryDao.getMotorcyclesByMake(make);
        List<VehicleViewModel> vvmList = new ArrayList<>();

        for(Motorcycle m : motorcycleList) {
            vvmList.add(buildVehicleViewModel(m));
        }
        return vvmList;
    }


    private VehicleViewModel buildVehicleViewModel(Motorcycle motorcycle) {
        VehicleViewModel vvm = new VehicleViewModel();
        vvm.setId(motorcycle.getId());
        vvm.setVin(motorcycle.getVin());
        vvm.setMake(motorcycle.getMake());
        vvm.setModel(motorcycle.getModel());
        vvm.setYear(motorcycle.getYear());
        vvm.setColor(motorcycle.getColor());

        return vvm;
    }
}
