package com.example.motoinventoryservice.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name="vin-lookup")
public interface VinLookupClient {

    @RequestMapping(value="/vehicle/{vin}", method= RequestMethod.GET)
    public Map getVehicleInformation(@PathVariable String vin);
}
