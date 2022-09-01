package com.qa.cinema.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class BookingTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Booking#Booking()}
     *   <li>{@link Booking#setBookerName(String)}
     *   <li>{@link Booking#setId(Long)}
     *   <li>{@link Booking#setMovieDate(Date)}
     *   <li>{@link Booking#setMovieTitle(String)}
     *   <li>{@link Booking#setNumberOfSeats(Long)}
     *   <li>{@link Booking#setTicketType(String)}
     *   <li>{@link Booking#setTotal(Long)}
     *   <li>{@link Booking#toString()}
     *   <li>{@link Booking#getBookerName()}
     *   <li>{@link Booking#getId()}
     *   <li>{@link Booking#getMovieTitle()}
     *   <li>{@link Booking#getNumberOfSeats()}
     *   <li>{@link Booking#getTicketType()}
     *   <li>{@link Booking#getTotal()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Booking actualBooking = new Booking();
        actualBooking.setBookerName("Booker Name");
        actualBooking.setId(123L);
        actualBooking.setMovieDate(mock(Date.class));
        actualBooking.setMovieTitle("Dr");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Ticket Type");
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("Booker Name", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Dr", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Ticket Type", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Booking#Booking(Long, String, Date, String, Long, String, Long)}
     *   <li>{@link Booking#setBookerName(String)}
     *   <li>{@link Booking#setId(Long)}
     *   <li>{@link Booking#setMovieDate(Date)}
     *   <li>{@link Booking#setMovieTitle(String)}
     *   <li>{@link Booking#setNumberOfSeats(Long)}
     *   <li>{@link Booking#setTicketType(String)}
     *   <li>{@link Booking#setTotal(Long)}
     *   <li>{@link Booking#toString()}
     *   <li>{@link Booking#getBookerName()}
     *   <li>{@link Booking#getId()}
     *   <li>{@link Booking#getMovieTitle()}
     *   <li>{@link Booking#getNumberOfSeats()}
     *   <li>{@link Booking#getTicketType()}
     *   <li>{@link Booking#getTotal()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Booking actualBooking = new Booking(123L, "Dr", mock(Date.class), "Booker Name", 1L, "Ticket Type", 1L);
        actualBooking.setBookerName("Booker Name");
        actualBooking.setId(123L);
        actualBooking.setMovieDate(mock(Date.class));
        actualBooking.setMovieTitle("Dr");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Ticket Type");
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("Booker Name", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Dr", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Ticket Type", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Booking#Booking(String, Date, String, Long, String, Long)}
     *   <li>{@link Booking#setBookerName(String)}
     *   <li>{@link Booking#setId(Long)}
     *   <li>{@link Booking#setMovieDate(Date)}
     *   <li>{@link Booking#setMovieTitle(String)}
     *   <li>{@link Booking#setNumberOfSeats(Long)}
     *   <li>{@link Booking#setTicketType(String)}
     *   <li>{@link Booking#setTotal(Long)}
     *   <li>{@link Booking#toString()}
     *   <li>{@link Booking#getBookerName()}
     *   <li>{@link Booking#getId()}
     *   <li>{@link Booking#getMovieTitle()}
     *   <li>{@link Booking#getNumberOfSeats()}
     *   <li>{@link Booking#getTicketType()}
     *   <li>{@link Booking#getTotal()}
     * </ul>
     */
    @Test
    void testConstructor3() {
        Booking actualBooking = new Booking("Dr", mock(Date.class), "Booker Name", 1L, "Ticket Type", 1L);
        actualBooking.setBookerName("Booker Name");
        actualBooking.setId(123L);
        actualBooking.setMovieDate(mock(Date.class));
        actualBooking.setMovieTitle("Dr");
        actualBooking.setNumberOfSeats(1L);
        actualBooking.setTicketType("Ticket Type");
        actualBooking.setTotal(1L);
        actualBooking.toString();
        assertEquals("Booker Name", actualBooking.getBookerName());
        assertEquals(123L, actualBooking.getId().longValue());
        assertEquals("Dr", actualBooking.getMovieTitle());
        assertEquals(1L, actualBooking.getNumberOfSeats().longValue());
        assertEquals("Ticket Type", actualBooking.getTicketType());
        assertEquals(1L, actualBooking.getTotal().longValue());
    }

    /**
     * Method under test: {@link Booking#equals(Object)}
     */
    @Test
    void testEquals() {
        Booking booking = new Booking();
        booking.setBookerName("Booker Name");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Dr");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Ticket Type");
        booking.setTotal(1L);
        assertNotEquals(booking, null);
    }

    /**
     * Method under test: {@link Booking#equals(Object)}
     */
    @Test
    void testEquals2() {
        Booking booking = new Booking();
        booking.setBookerName("Booker Name");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Dr");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Ticket Type");
        booking.setTotal(1L);
        assertNotEquals(booking, "Different type to Booking");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Booking#equals(Object)}
     *   <li>{@link Booking#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Booking booking = new Booking();
        booking.setBookerName("Booker Name");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Dr");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Ticket Type");
        booking.setTotal(1L);
        assertEquals(booking, booking);
        int expectedHashCodeResult = booking.hashCode();
        assertEquals(expectedHashCodeResult, booking.hashCode());
    }

    /**
     * Method under test: {@link Booking#equals(Object)}
     */
    @Test
    void testEquals4() {
        Booking booking = new Booking();
        booking.setBookerName("Booker Name");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Dr");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Ticket Type");
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("Booker Name");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Dr");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Ticket Type");
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }

    /**
     * Method under test: {@link Booking#equals(Object)}
     */
    @Test
    void testEquals5() {
        Booking booking = new Booking();
        booking.setBookerName("Booker Name");
        booking.setId(1L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Dr");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Ticket Type");
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("Booker Name");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Dr");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Ticket Type");
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }

    /**
     * Method under test: {@link Booking#equals(Object)}
     */
    @Test
    void testEquals6() {
        Booking booking = new Booking();
        booking.setBookerName("Booker Name");
        booking.setId(123L);
        booking.setMovieDate(mock(Date.class));
        booking.setMovieTitle("Movie Title");
        booking.setNumberOfSeats(1L);
        booking.setTicketType("Ticket Type");
        booking.setTotal(1L);

        Booking booking1 = new Booking();
        booking1.setBookerName("Booker Name");
        booking1.setId(123L);
        booking1.setMovieDate(mock(Date.class));
        booking1.setMovieTitle("Dr");
        booking1.setNumberOfSeats(1L);
        booking1.setTicketType("Ticket Type");
        booking1.setTotal(1L);
        assertNotEquals(booking, booking1);
    }
}

