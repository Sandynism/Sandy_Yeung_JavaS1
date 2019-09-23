package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.model.BookingViewModel;
import com.trilogyed.hotelbookingservice.model.HotelBooking;
import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    RewardsClient rewardsClient;
    RoomClient roomClient;

    @Before
    public void setUp() throws Exception {
        setUpRewardsClientMocks();
        setUpRoomClientMocks();

        serviceLayer = new ServiceLayer(rewardsClient, roomClient);
    }

    private void setUpRewardsClientMocks() {
        rewardsClient = mock(RewardsClient.class);


        Rewards reward = new Rewards();
        reward.setId(1);
        reward.setRoomType("King");
        reward.setDiscount(0.2f);
        reward.setPoints(0);
        reward.setCanDouble(false);

        doReturn(reward).when(rewardsClient).getRewards("King");
    }

    private void setUpRoomClientMocks() {
        roomClient = mock(RoomClient.class);

        Room room = new Room();
        room.setNumber(222);
        room.setRoomType("King");
        room.setBaseRate(200.00f);

        doReturn(room).when(roomClient).getRoom(222);
    }


    @Test
    public void getBooking() {
        BookingViewModel hotelBooking = serviceLayer.getBooking(222, false, false);
    }

    @Test
    public void saveBooking() {
    }
}