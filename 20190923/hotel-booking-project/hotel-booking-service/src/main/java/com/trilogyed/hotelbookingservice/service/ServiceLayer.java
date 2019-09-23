package com.trilogyed.hotelbookingservice.service;

//import com.trilogyed.hotelbookingservice.dao.HotelBookingDao;
import com.trilogyed.hotelbookingservice.model.BookingViewModel;
import com.trilogyed.hotelbookingservice.model.HotelBooking;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
@Service
public class ServiceLayer {

    //    private HotelBookingDao hotelBookingDao;
    private RewardsClient rewardsClient;
    private RoomClient roomClient;

    //    public ServiceLayer(HotelBookingDao hotelBookingDao, RewardsClient rewardsClient, RoomClient roomClient) {
//        this.hotelBookingDao = hotelBookingDao;
    @Autowired
    public ServiceLayer(RewardsClient rewardsClient, RoomClient roomClient) {
//        this.hotelBookingDao = hotelBookingDao;
        this.rewardsClient = rewardsClient;
        this.roomClient = roomClient;
    }

    public BookingViewModel getBooking(int roomId, boolean isRewardsMember, boolean isDoubleBonusDay) {
        return buildBookingViewModel(roomId, isRewardsMember, isDoubleBonusDay, rewardsClient, roomClient);

    }

//    @Transactional
    public BookingViewModel saveBooking(BookingViewModel bvm) {
        HotelBooking booking = new HotelBooking();
        booking.setRoomId(bvm.getRoomId());
        booking.setRewardsMember(bvm.getRewardsMember());
        booking.setDoubleBonusDay(bvm.getDoubleBonusDay());
        booking.setBaseRate(bvm.getBaseRate());
        booking.setMemberDiscount(bvm.getMemberDiscount());
        booking.setBaseRewardsPoints(bvm.getBaseRewardsPoints());
        booking.setCanDouble(bvm.getCanDouble());
        booking.setFinalCost(bvm.getFinalCost());
        booking.setTotalRewardsPoints(bvm.getTotalRewardsPoints());

//        booking = hotelBookingDao.addHotelBooking(booking);

        bvm.setRoomId(booking.getRoomId());
        bvm.setRewardsMember(booking.getRewardsMember());
        bvm.setDoubleBonusDay(booking.getDoubleBonusDay());
        bvm.setBaseRate(booking.getBaseRate());
        bvm.setMemberDiscount(booking.getMemberDiscount());
        bvm.setBaseRewardsPoints(booking.getBaseRewardsPoints());
        bvm.setCanDouble(booking.getCanDouble());
        bvm.setFinalCost(booking.getFinalCost());
        bvm.setTotalRewardsPoints(booking.getTotalRewardsPoints());

        return bvm;
    }

//    public Room getRoom(int number) {
//        return roomClient.getRoom(number);
//    }
//
//    public List<Room> getAllRooms() {
//        return roomClient.getAllRooms();
//    }
//
//    public Rewards getRewards(String roomType) {
//        return rewardsClient.getRewards(roomType);
//    }
//
//    public List<Rewards> getAllRewards() {
//        return rewardsClient.getAllRewards();
//    }

    private BookingViewModel buildBookingViewModel(int roomId, boolean isRewardsMember, boolean isDoubleBonusDay, RewardsClient rewardsClient, RoomClient roomClient) {

        String roomType = roomClient.getRoom(roomId).getRoomType();
        Float baseRate = roomClient.getRoom(roomId).getBaseRate();
        Float memberDiscount = rewardsClient.getRewards(roomType).getDiscount();
        Integer baseRewardsPoints = rewardsClient.getRewards(roomType).getPoints();
        Boolean canDouble = rewardsClient.getRewards(roomType).getCanDouble();
        Float finalCost = baseRate;
        Integer totalRewardsPoints = baseRewardsPoints;

        if (!isRewardsMember) {
            totalRewardsPoints = 0;
            finalCost = baseRate;
        }

        while (isRewardsMember) {
            if (isDoubleBonusDay && canDouble) {
                totalRewardsPoints = baseRewardsPoints * 2;
            } else {
                totalRewardsPoints = baseRewardsPoints;
            }
            finalCost = baseRate * (1 - memberDiscount);
        }

        BookingViewModel bvm = new BookingViewModel();

        bvm.setRoomId(roomId);
        bvm.setRewardsMember(isRewardsMember);
        bvm.setDoubleBonusDay(isDoubleBonusDay);
        bvm.setBaseRate(baseRate);
        bvm.setMemberDiscount(memberDiscount);
        bvm.setBaseRewardsPoints(baseRewardsPoints);
        bvm.setCanDouble(canDouble);
        bvm.setFinalCost(finalCost);
        bvm.setTotalRewardsPoints(totalRewardsPoints);

        return bvm;
    }

}

//Your service will calculate the cost of a hotel room, and any rewards points for a given hotel room. The calculation will take the following into account:
//
//* Whether the customer is a rewards member
//* Whether the room is discount eligible
//* Whether today is a Double Bonus Day
//* Whether the room can have its rewards points doubled
//
//Notes:
//* If ```doubleBonusDay``` is true and ```canDouble``` is true on the room, ```totalRewardsPoints``` is ```baseRewardsPoints * 2```.
//* If ```rewardsMember``` is false, ```totalRewardPoints``` is 0.
//* If ```rewardsMember``` is true, ```finalCost``` is ```baseRate * (1 - memberDiscount)```