package com.qa.cinema.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.qa.cinema.domain.Booking;
import com.qa.cinema.repo.BookingRepo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingService.class})
@ExtendWith(SpringExtension.class)
class BookingServiceTest {
    @MockBean
    private BookingRepo bookingRepo;

    @Autowired
    private BookingService bookingService;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void testAddBooking() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        when(bookingRepo.save((Booking) any())).thenReturn(booking);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Ghostbusters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTotal(1L);
        assertSame(booking, bookingService.addBooking(booking1));
        verify(bookingRepo).save((Booking) any());
    }

    @Test
    void testReadBooking() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        Optional<Booking> ofResult = Optional.of(booking);
        when(bookingRepo.findById((Long) any())).thenReturn(ofResult);
        assertSame(booking, bookingService.readBooking(123L));
        verify(bookingRepo).findById((Long) any());
    }


    @Test
    void testReadAllBookings() {
        ArrayList<Booking> bookingList = new ArrayList<>();
        when(bookingRepo.findAll()).thenReturn(bookingList);
        List<Booking> actualReadAllBookingsResult = bookingService.readAllBookings();
        assertSame(bookingList, actualReadAllBookingsResult);
        assertTrue(actualReadAllBookingsResult.isEmpty());
        verify(bookingRepo).findAll();
    }

    @Test
    void testUpdateBooking() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        Optional<Booking> ofResult = Optional.of(booking);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Ghostbusters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTotal(1L);
        when(bookingRepo.save((Booking) any())).thenReturn(booking1);
        when(bookingRepo.findById((Long) any())).thenReturn(ofResult);

        Booking booking2 = new Booking();
        booking2.setBookerName("John Smith");
        booking2.setId(123L);
        booking2.setMovieDate(mock(Date.class));
        booking2.setMovieTitle("Ghostbusters");
        booking2.setNumberOfSeats(1L);
        booking2.setTicketType("Adult");
        booking2.setTotal(1L);
        assertSame(booking1, bookingService.updateBooking(booking2, 123L));
        verify(bookingRepo).save((Booking) any());
        verify(bookingRepo).findById((Long) any());
    }

    @Test
    void testDeleteByBookingID() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        Optional<Booking> ofResult = Optional.of(booking);
        doNothing().when(bookingRepo).deleteById((Long) any());
        when(bookingRepo.findById((Long) any())).thenReturn(ofResult);
        assertTrue(bookingService.deleteByBookingID(123L));
        verify(bookingRepo).findById((Long) any());
        verify(bookingRepo).deleteById((Long) any());
    }


    @Test
    void testDeleteByBookingID2() {
        doNothing().when(bookingRepo).deleteById((Long) any());
        when(bookingRepo.findById((Long) any())).thenReturn(Optional.empty());
        assertFalse(bookingService.deleteByBookingID(123L));
        verify(bookingRepo).findById((Long) any());
    }
}

