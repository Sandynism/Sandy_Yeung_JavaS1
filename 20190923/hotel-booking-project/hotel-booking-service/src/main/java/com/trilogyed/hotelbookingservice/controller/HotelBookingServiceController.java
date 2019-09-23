package com.trilogyed.hotelbookingservice.controller;

import com.trilogyed.hotelbookingservice.exception.NotFoundException;
import com.trilogyed.hotelbookingservice.model.BookingViewModel;
import com.trilogyed.hotelbookingservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class HotelBookingServiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping(value = {"/hotelRewards/{roomId}?rewardsMember={rewardsMember}&doubleBonusDay={doubleBonusDay}",
            "/hotelRewards/{roomId}"})
    @ResponseStatus(HttpStatus.OK)
    public BookingViewModel getBookingRates(@PathVariable("roomId") int roomId,
                                            @RequestParam(required = false, defaultValue = "false") boolean rewardsMember,
                                            @RequestParam(required = false, defaultValue = "false") boolean doubleBonusDay) {
        return serviceLayer.getBooking(roomId, rewardsMember, doubleBonusDay);
    }

}