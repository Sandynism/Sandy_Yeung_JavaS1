package com.trilogyed.hotelbookingservice.controller;

import com.trilogyed.hotelbookingservice.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelBookingServiceController.class)
public class HotelBookingServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getHotelBookingInfo() {
    }

    @Test
    public void addHotelBooking() {
    }
}