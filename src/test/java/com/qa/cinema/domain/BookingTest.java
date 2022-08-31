package com.qa.cinema.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class BookingTest {

    @Test
    void testConstructor() {
        Booking actualBooking = new Booking();
        actualBooking.setBookerName("John Smith");
        actualBooking.setDate(mock(Date.class));
        actualBooking.setId(123L);
        actualBooking.setMovieTitle("Ghost-Busters");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Adult");
        actualBooking.setTime(mock(Timestamp.class));
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("John Smith", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Ghost-Busters", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Adult", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }

    @Test
    void testConstructor2() {
        Booking actualBooking = new Booking(123L, "Ghost-Busters", mock(Date.class), mock(Timestamp.class), "John Smith", 1L,
                "Adult", 1L);
        actualBooking.setBookerName("John Smith");
        actualBooking.setDate(mock(Date.class));
        actualBooking.setId(123L);
        actualBooking.setMovieTitle("Ghost-Busters");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Adult");
        actualBooking.setTime(mock(Timestamp.class));
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("John Smith", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Ghost-Busters", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Adult", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }


    @Test
    void testConstructor3() {
        Booking actualBooking = new Booking("Ghost-Busters", mock(Date.class), mock(Timestamp.class), "John Smith", 1L,
                "Adult", 1L);
        actualBooking.setBookerName("John Smith");
        actualBooking.setDate(mock(Date.class));
        actualBooking.setId(123L);
        actualBooking.setMovieTitle("Ghost-Busters");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Adult");
        actualBooking.setTime(mock(Timestamp.class));
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("John Smith", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Ghost-Busters", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Adult", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }

    @Test
    void testEquals() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setDate(mock(Date.class));
        booking.setId(123L);
        booking.setMovieTitle("Ghost-Busters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTime(mock(Timestamp.class));
        booking.setTotal(1L);
        assertNotEquals(booking, null);
    }

    @Test
    void testEquals2() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setDate(mock(Date.class));
        booking.setId(123L);
        booking.setMovieTitle("Ghost-Busters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTime(mock(Timestamp.class));
        booking.setTotal(1L);
        assertNotEquals(booking, "Different type to Booking");
    }


    @Test
    void testEquals3() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setDate(mock(Date.class));
        booking.setId(123L);
        booking.setMovieTitle("Ghost-Busters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTime(mock(Timestamp.class));
        booking.setTotal(1L);
        assertEquals(booking, booking);
        int expectedHashCodeResult = booking.hashCode();
        assertEquals(expectedHashCodeResult, booking.hashCode());
    }

    @Test
    void testEquals4() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setDate(mock(Date.class));
        booking.setId(123L);
        booking.setMovieTitle("Ghost-Busters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTime(mock(Timestamp.class));
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setDate(mock(Date.class));
        booking1.setId(123L);
        booking1.setMovieTitle("Ghost-Busters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTime(mock(Timestamp.class));
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }


    @Test
    void testEquals5() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setDate(mock(Date.class));
        booking.setId(1L);
        booking.setMovieTitle("Ghost-Busters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTime(mock(Timestamp.class));
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setDate(mock(Date.class));
        booking1.setId(123L);
        booking1.setMovieTitle("Ghost-Busters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTime(mock(Timestamp.class));
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }


    @Test
    void testEquals6() {
        Booking booking = new Booking();
        booking.setBookerName("John Smith");
        booking.setDate(mock(Date.class));
        booking.setId(123L);
        booking.setMovieTitle("Ghost-Busters");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Adult");
        booking.setTime(mock(Timestamp.class));
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("John Smith");
        booking1.setDate(mock(Date.class));
        booking1.setId(123L);
        booking1.setMovieTitle("Ghost-Busters");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Adult");
        booking1.setTime(mock(Timestamp.class));
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }
}

