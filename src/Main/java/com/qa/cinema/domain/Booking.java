package com.qa.cinema.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 15)
    private String movieTitle;

    @NotNull
    private Date date;

    @NotNull
    private Timestamp time;

    @NotNull
    @Column (length = 15)
    private String bookerName;

    @NotNull
    @Min(1)
    private Long numberOfSeats;

    @NotNull
    @Column (length = 15)
    private String ticketType;

    @NotNull
    private Long total;

    public Booking() {
    }

    public Booking(String movieTitle, Date date, Timestamp time, String bookerName, Long numberOfSeats, String ticketType, Long total) {
        this.movieTitle = movieTitle;
        this.date = date;
        this.time = time;
        this.bookerName = bookerName;
        this.numberOfSeats = numberOfSeats;
        this.ticketType = ticketType;
        this.total = total;
    }

    public Booking(Long id, String movieTitle, Date date, Timestamp time, String bookerName, Long numberOfSeats, String ticketType, Long total) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.date = date;
        this.time = time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(movieTitle, booking.movieTitle) && Objects.equals(date, booking.date) && Objects.equals(time, booking.time) && Objects.equals(bookerName, booking.bookerName) && Objects.equals(numberOfSeats, booking.numberOfSeats) && Objects.equals(ticketType, booking.ticketType) && Objects.equals(total, booking.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieTitle, date, time, bookerName, numberOfSeats, ticketType, total);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", bookerName='" + bookerName + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", ticketType='" + ticketType + '\'' +
                ", total=" + total +
                '}';
    }
}
