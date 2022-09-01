package com.qa.cinema.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cinema.domain.Booking;
import com.qa.cinema.service.BookingService;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookingController.class})
@ExtendWith(SpringExtension.class)
class BookingControllerTest {
    @Autowired
    private BookingController bookingController;

    @MockBean
    private BookingService bookingService;

    @Test
    void testCreatebooking() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);

        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(date);
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        when(bookingService.addBooking((Booking) any())).thenReturn(booking);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setId(123L);
        booking1.setMovieDate(date1);
        booking1.setMovieTitle("Ghostbusters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTotal(1L);
        String content = (new ObjectMapper()).writeValueAsString(booking1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/Booking/createBooking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"movieTitle\":\"Ghostbusters\",\"movieDate\":10,\"bookerName\":\"John Smith\",\"numberOfSeats\":1,\"ticketType\":\"Adult\",\"total\":1}"));
    }

    @Test
    void testUpdateBooking() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);

        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(date);
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        when(bookingService.updateBooking((Booking) any(), (Long) any())).thenReturn(booking);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setId(123L);
        booking1.setMovieDate(date1);
        booking1.setMovieTitle("Ghostbusters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTotal(1L);
        String content = (new ObjectMapper()).writeValueAsString(booking1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/Booking/updateBooking/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"movieTitle\":\"Ghostbusters\",\"movieDate\":10,\"bookerName\":\"John Smith\",\"numberOfSeats\":1,\"ticketType\":\"Adult\",\"total\":1}"));
    }

    @Test
    void testDeleteBooking() throws Exception {
        when(bookingService.deleteByBookingID((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/Booking/deleteBooking/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testDeleteBooking2() throws Exception {
        when(bookingService.deleteByBookingID((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/Booking/deleteBooking/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testDeleteBooking3() throws Exception {
        when(bookingService.deleteByBookingID((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/Booking/deleteBooking/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(deleteResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testGetBooking() throws Exception {
        when(bookingService.readAllBookings()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Booking/getBooking");
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetBooking2() throws Exception {
        when(bookingService.readAllBookings()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Booking/getBooking");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

