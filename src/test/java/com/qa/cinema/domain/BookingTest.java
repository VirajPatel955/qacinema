package com.qa.cinema.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class BookingTest {

    @Test
    void testConstructor() {
        Booking actualBooking = new Booking();
        actualBooking.setBookerName("John Smith");
        actualBooking.setId(123L);
        actualBooking.setMovieDate(mock(Date.class));
        actualBooking.setMovieTitle("Ghostbusters");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Adult");
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("John Smith", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Ghostbusters", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Adult", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }

    @Test
    void testConstructor2() {
        Booking actualBooking = new Booking(123L, "Ghostbusters", mock(Date.class), "John Smith", 1L, "Adult", 1L);
        actualBooking.setBookerName("John Smith");
        actualBooking.setId(123L);
        actualBooking.setMovieDate(mock(Date.class));
        actualBooking.setMovieTitle("Ghostbusters");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Adult");
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("John Smith", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Ghostbusters", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Adult", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }


    @Test
    void testConstructor3() {
        Booking actualBooking = new Booking("Ghostbusters", mock(Date.class), "John Smith", 1L, "Adult", 1L);
        actualBooking.setBookerName("John Smith");
        actualBooking.setId(123L);
        actualBooking.setMovieDate(mock(Date.class));
        actualBooking.setMovieTitle("Ghostbusters");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Adult");
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("John Smith", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Ghostbusters", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Adult", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }

    @Test
    void testEquals() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        assertNotEquals(booking, null);
    }


    @Test
    void testEquals2() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        assertNotEquals(booking, "Different type to Booking");
    }

    @Test
    void testEquals3() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);
        assertEquals(booking, booking);
        int expectedHashCodeResult = booking.hashCode();
        assertEquals(expectedHashCodeResult, booking.hashCode());
    }

    @Test
    void testEquals4() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Ghostbusters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }

    @Test
    void testEquals5() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(1L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Ghostbusters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Ghostbusters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }


    @Test
    void testEquals6() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Movie Title");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Ghostbusters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }
}

