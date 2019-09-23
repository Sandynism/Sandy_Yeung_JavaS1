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

//    public HotelBookingServiceController(ServiceLayer serviceLayer) {
//        this.serviceLayer = serviceLayer;
//    }

//    @RequestMapping(value = "/hotelRewards/{roomId}?rewardsMember=[true|false]&doubleBonusDay=[true|false]", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public BookingViewModel getHotelBookingInfo(@PathVariable("roomId") int roomId, @RequestParam(value = "rewardsMember", required = false, defaultValue = "false")
//            boolean rewardsMember, @RequestParam(value = "doubleBonusDay", required = false, defaultValue = "false") boolean doubleBonusDay) {
////
////        BookingViewModel bvm = serviceLayer.getBooking(roomId, rewardsMember, doubleBonusDay);
////
////        if(bvm == null)
////            throw new NotFoundException("Booking could not be retrieved for room " + roomId);
//
//        return serviceLayer.getBooking(roomId, rewardsMember, doubleBonusDay);
//    }

    @RequestMapping(value = "/hotelRewards/{roomId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public BookingViewModel getHotelBookingInfo(@PathVariable("roomId") int roomId, @RequestParam(value = "rewardsMember", required = false, defaultValue = "false")
            boolean rewardsMember, @RequestParam(value = "doubleBonusDay", required = false, defaultValue = "false") boolean doubleBonusDay) {
//
//        BookingViewModel bvm = serviceLayer.getBooking(roomId, rewardsMember, doubleBonusDay);
//
//        if(bvm == null)
//            throw new NotFoundException("Booking could not be retrieved for room " + roomId);

        return serviceLayer.getBooking(roomId, rewardsMember, doubleBonusDay);
//        return "This gets hit." + roomId + rewardsMember + doubleBonusDay;
    }

    @RequestMapping(value="/hotelBooking", method = RequestMethod.POST)
    public BookingViewModel addHotelBooking(@RequestBody BookingViewModel bvm) {
        serviceLayer.saveBooking(bvm);
        return bvm;
    }
}


//* URL: /hotelRewards/{roomId}?rewardsMember=[true|false]&doubleBonusDay=[true|false]
//        * HTTP Method: GET
//        * RequestBody: None
//        * ResponseBody: Room rate and rewards (JSON - see below)
//
//        #### Response Format
//
//        ```javascript
//{
//   "roomId":"237",
//   "rewardsMember":"true",
//   "doubleBonusDay":"true",
//   "baseRate":"200.00",
//   "memberDiscount":".10",
//   "baseRewardsPoints":"2100",
//   "canDouble":"true",
//   "finalCost":"180.00"
//   "totalRewardsPoints":"4200"
//}