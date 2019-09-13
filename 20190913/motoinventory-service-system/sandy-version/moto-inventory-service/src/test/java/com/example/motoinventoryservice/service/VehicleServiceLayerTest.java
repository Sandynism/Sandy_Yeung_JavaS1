package com.example.motoinventoryservice.service;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.dao.MotoInventoryDaoJdbcTemplateImpl;
import com.example.motoinventoryservice.model.Motorcycle;
import com.example.motoinventoryservice.viewModel.VehicleViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class VehicleServiceLayerTest {

    MotoInventoryDao motoInventoryDao;
    VehicleServiceLayer vehicleServiceLayer;

    @Before
    public void setUp() throws Exception {
        setUpMotoInventoryDaoMocks();
        vehicleServiceLayer = new VehicleServiceLayer(motoInventoryDao);
    }

    private void setUpMotoInventoryDaoMocks(){
        motoInventoryDao = mock(MotoInventoryDaoJdbcTemplateImpl.class);

        Motorcycle moto = new Motorcycle();
        moto.setId(1);
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        Motorcycle moto1 = new Motorcycle();
        moto1.setVin("12345");
        moto1.setMake("Honda");
        moto1.setModel("Africa Twin");
        moto1.setYear("2019");
        moto1.setColor("black");

        List<Motorcycle> motoList = new ArrayList<>();
        motoList.add(moto);

        Motorcycle motoUpdate = new Motorcycle();
        motoUpdate.setId(2);
        motoUpdate.setVin("12345");
        motoUpdate.setMake("Updated Honda");
        motoUpdate.setModel("Updated Africa Twin");
        motoUpdate.setYear("2019");
        motoUpdate.setColor("black");

        Motorcycle moto3 = new Motorcycle();
        moto3.setId(3);
        moto3.setVin("54321");
        moto3.setMake("Suzuki");
        moto3.setModel("DR650");
        moto3.setYear("2012");
        moto3.setColor("gray");

        motoList.add(moto3);

        List<Motorcycle> makeList = new ArrayList<>();
        makeList.add(moto);

        doReturn(moto).when(motoInventoryDao).addMotorcycle(moto1);
        doReturn(moto).when(motoInventoryDao).getMotorcycle(1);
        doReturn(motoList).when(motoInventoryDao).getAllMotorcycles();
        doNothing().when(motoInventoryDao).updateMotorcycle(motoUpdate);
        doReturn(motoUpdate).when(motoInventoryDao).getMotorcycle(2);
        doNothing().when(motoInventoryDao).deleteMotorcycle(3);
        doReturn(null).when(motoInventoryDao).getMotorcycle(3);
        doReturn(makeList).when(motoInventoryDao).getMotorcyclesByMake("Honda");
    }

    @Test
    public void saveFindDeleteUpdateMotorcycle() {
        VehicleViewModel moto = new VehicleViewModel();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        moto = vehicleServiceLayer.saveMotorcycle(moto);
        VehicleViewModel fromService = vehicleServiceLayer.findMotorcycle(moto.getId());
        assertEquals(moto, fromService);

        moto = new VehicleViewModel();

        Motorcycle motoUpdate = new Motorcycle();
        motoUpdate.setId(2);
        motoUpdate.setVin("12345");
        motoUpdate.setMake("Updated Honda");
        motoUpdate.setModel("Updated Africa Twin");
        motoUpdate.setYear("2019");
        motoUpdate.setColor("black");

        moto.setId(motoUpdate.getId());
        moto.setVin(motoUpdate.getVin());
        moto.setMake(motoUpdate.getMake());
        moto.setModel(motoUpdate.getModel());
        moto.setYear(motoUpdate.getYear());
        moto.setColor(motoUpdate.getColor());

        vehicleServiceLayer.updateMotorcycle(moto);

        fromService = vehicleServiceLayer.findMotorcycle(2);

        Motorcycle moto3 = new Motorcycle();
        moto3.setId(fromService.getId());
        moto3.setVin(fromService.getVin());
        moto3.setMake(fromService.getMake());
        moto3.setModel(fromService.getModel());
        moto3.setYear(fromService.getYear());
        moto3.setColor(fromService.getColor());

        assertEquals(motoUpdate, moto3);

        vehicleServiceLayer.deleteMotorcycle(3);
        fromService = vehicleServiceLayer.findMotorcycle(3);
        assertNull(fromService);
    }

    @Test
    public void findMotorcyclesByMake() {
        VehicleViewModel moto = new VehicleViewModel();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        moto = vehicleServiceLayer.saveMotorcycle(moto);
        List<VehicleViewModel> fromService = vehicleServiceLayer.findMotorcyclesByMake("Honda");
        assertEquals(fromService.size(), 1);

        fromService = vehicleServiceLayer.findMotorcyclesByMake("Audi");
        assertEquals(fromService.size(), 0);
    }
}
