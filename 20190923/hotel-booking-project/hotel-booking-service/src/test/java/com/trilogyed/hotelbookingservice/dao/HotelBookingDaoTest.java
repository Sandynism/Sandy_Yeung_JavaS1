//package com.trilogyed.hotelbookingservice.dao;
//
//import com.trilogyed.hotelbookingservice.model.HotelBooking;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class HotelBookingDaoTest {
//
//    @Autowired
//    HotelBookingDao dao;
//
//    @Before
//    public void setUp() throws Exception {
//        List<HotelBooking> hotelBookingList = dao.getAllHotelBookings();
//        for(HotelBooking b: hotelBookingList) {
//            dao.deleteHotelBooking(b.getRoomId());
//        }
//    }
//
//    @Test
//    public void addGetDeleteUpdateHotelBooking() {
//        HotelBooking booking = new HotelBooking();
//        booking.setRoomId(1);
//        booking.setRewardsMember(false);
//        booking.setDoubleBonusDay(false);
//        booking.setBaseRate(100.00f);
//        booking.setMemberDiscount(0.0f);
//        booking.setBaseRewardsPoints(0);
//        booking.setCanDouble(false);
//        booking.setFinalCost(100.00f);
//        booking.setTotalRewardsPoints(0);
//
//        dao.addHotelBooking(booking);
//
//        HotelBooking booking1 = dao.getHotelBooking(booking.getRoomId());
//        assertEquals(booking, booking1);
//
//        dao.deleteHotelBooking(booking.getRoomId());
//        booking1 = dao.getHotelBooking(booking.getRoomId());
//        assertNull(booking1);
//    }
//
//
////    @Test
////    public void getAllHotelBookings() {
////    }
//
//
//}