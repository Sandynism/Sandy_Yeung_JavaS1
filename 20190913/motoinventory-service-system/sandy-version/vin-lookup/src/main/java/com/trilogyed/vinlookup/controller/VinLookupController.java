package com.trilogyed.vinlookup.controller;

import com.trilogyed.vinlookup.model.Vehicle;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RefreshScope
public class VinLookupController {

    private String[] types = {"Motorcycle", "Truck", "Automobile", "Other"};
    private String[] makes = {"Honda", "Suzuki", "Subaru", "Ford", "Cheverolet"};
    private String[] models = {"Africa Twin", "F-150", "Outback", "Malibu", "DL650", "CBR100RR"};
    private String[] colors = {"Red", "Blue", "White", "Black", "Grey", "Tan", "Silver", "Orange"};
    private String[] years = {"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"};

    Random rndGen = new Random();

    @RequestMapping (value = "/vehicle/{vin}", method = RequestMethod.GET)
    public Map<String, String> lookUpVehicle(@PathVariable String vin) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(types[rndGen.nextInt(4)]);
        vehicle.setMake(makes[rndGen.nextInt(5)]);
        vehicle.setModel(models[rndGen.nextInt(6)]);
        vehicle.setColor(colors[rndGen.nextInt(8)]);
        vehicle.setYear(years[rndGen.nextInt(12)]);

        Map<String, String> vehicleInformation = new HashMap<>();
        vehicleInformation.put("Vehicle Type", vehicle.getType());
        vehicleInformation.put("Vehicle Make", vehicle.getMake());
        vehicleInformation.put("Vehicle Model", vehicle.getModel());
        vehicleInformation.put("Vehicle Year", vehicle.getYear());
        vehicleInformation.put("Vehicle Color", vehicle.getColor());

        return vehicleInformation;
    }
}
