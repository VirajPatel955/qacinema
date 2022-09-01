package com.qa.cinema.Controller;

import java.util.List;

import com.qa.cinema.domain.Booking;
import com.qa.cinema.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Booking")
public class BookingController {

    @Autowired
    BookingService service;

    @Autowired
    public BookingController(BookingService Service) {
        this.service = Service;
    }

    @PostMapping("/createBooking")
    public ResponseEntity<Booking> createbooking(@RequestBody Booking booking) {
        Booking createBooking = this.service.addBooking(booking);

        return new ResponseEntity<Booking>(createBooking, HttpStatus.CREATED);
    }

    @GetMapping("/getBooking")
    public ResponseEntity<List<Booking>> getBooking() {
        List<Booking> bookingData = this.service.readAllBookings();

        return new ResponseEntity<List<Booking>>(bookingData, HttpStatus.OK);
    }

	@PutMapping("/updateBooking/{id}")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable Long id) {
		Booking updateBooking = service.updateBooking(booking, id);

		return new ResponseEntity<Booking>(updateBooking, HttpStatus.OK);
	}

	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable Long id) {

		Boolean deletedBooking = service.deleteByBookingID(id);

		return (deletedBooking) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
							: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
