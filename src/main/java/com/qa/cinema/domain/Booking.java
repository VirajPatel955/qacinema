package com.qa.cinema.domain;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 40)
	private String movieTitle;

	@NotNull
	private Date movieDate;

	@NotNull
	@Column(length = 40)
	private String bookerName;

	@NotNull
	@Min(1)
	private Long numberOfSeats;

	@NotNull
	@Column(length = 40)
	private String ticketType;

	@NotNull
	private Long total;

	public Booking() {
	}

	public Booking(String movieTitle, Date date, String bookerName, Long numberOfSeats, String ticketType, Long total) {
		this.movieTitle = movieTitle;
		this.movieDate = date;
		this.bookerName = bookerName;
		this.numberOfSeats = numberOfSeats;
		this.ticketType = ticketType;
		this.total = total;
	}

	public Booking(Long id, String movieTitle, Date date, String bookerName, Long numberOfSeats, String ticketType,
			Long total) {
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieDate = date;
		this.bookerName = bookerName;
		this.numberOfSeats = numberOfSeats;
		this.ticketType = ticketType;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public String getBookerName() {
		return bookerName;
	}

	public void setBookerName(String bookerName) {
		this.bookerName = bookerName;
	}

	public Long getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Booking booking = (Booking) o;
		return Objects.equals(id, booking.id) && Objects.equals(movieTitle, booking.movieTitle)
				&& Objects.equals(movieDate, booking.movieDate) && Objects.equals(bookerName, booking.bookerName)
				&& Objects.equals(numberOfSeats, booking.numberOfSeats)
				&& Objects.equals(ticketType, booking.ticketType) && Objects.equals(total, booking.total);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, movieTitle, movieDate, bookerName, numberOfSeats, ticketType, total);
	}

	@Override
	public String toString() {
		return "Booking{" + "id=" + id + ", movieTitle='" + movieTitle + '\'' + ", movieDate=" + movieDate
				+ ", bookerName='" + bookerName + '\'' + ", numberOfSeats=" + numberOfSeats + ", ticketType='"
				+ ticketType + '\'' + ", total=" + total + '}';
	}
}
