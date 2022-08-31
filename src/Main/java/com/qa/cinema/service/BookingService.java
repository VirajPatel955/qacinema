package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import com.qa.cinema.domain.Booking;
import com.qa.cinema.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepo repo;

    @Autowired
    public BookingService(BookingRepo repo) {
        this.repo = repo;
    }

    public Booking addBooking(Booking booking) {
        return repo.save(booking);
    }

    public Booking readBooking(Long id) {
        return repo.findById(id).get();
    }

    public List<Booking> readAllBookings() {
        return this.repo.findAll();
    }

    public Booking updatebooking(Booking updateBooking, Long id) {
        Optional<Booking> currentBooking = this.repo.findById(id);

        if (currentBooking.get() instanceof Booking) {
            Booking oldBooking = currentBooking.get();

            oldBooking.setMovieTitle(updateBooking.getMovieTitle());
            oldBooking.setDate(updateBooking.getDate());
            oldBooking.setTime(updateBooking.getTime());
            oldBooking.setBookerName(updateBooking.getBookerName());
            oldBooking.setNumberOfSeats(updateBooking.getNumberOfSeats());
            oldBooking.setTicketType(updateBooking.getTicketType());
            oldBooking.setTotal(updateBooking.getTotal());
            return repo.save(oldBooking);
        }
        return null;
    }

    public boolean deleteByBookingID(Long id) {
        Optional<Booking> currentBooking = this.repo.findById(id);

        boolean isPresent = (currentBooking.isPresent()) ?  true : false;

        if (isPresent) {
            this.repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
