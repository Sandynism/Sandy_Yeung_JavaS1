//package com.trilogyed.hotelbookingservice.dao;
//
//import com.trilogyed.hotelbookingservice.model.HotelBooking;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class HotelBookingDaoImpl implements HotelBookingDao {
//
//    @Autowired
//    HotelBookingDao dao;
////    private JdbcTemplate jdbcTemplate;
////
////    @Autowired
////    public HotelBookingDaoImpl(JdbcTemplate jdbcTemplate) {
////        this.jdbcTemplate = jdbcTemplate;
////    }
//
//    @Override
//    public HotelBooking addHotelBooking(HotelBooking booking) {
//        return dao.addHotelBooking(booking);
//    }
//
//    @Override
//    public HotelBooking getHotelBooking(int roomId) {
//        return dao.getHotelBooking(roomId);
//    }
//
//    @Override
//    public List<HotelBooking> getAllHotelBookings() {
//        return dao.getAllHotelBookings();
////        return null;
//    }
//
//    @Override
//    public void updateHotelBooking(HotelBooking booking) {
//        dao.updateHotelBooking(booking);
//    }
//
//    @Override
//    public void deleteHotelBooking(int roomId) {
//        dao.deleteHotelBooking(roomId);
//    }
//}
