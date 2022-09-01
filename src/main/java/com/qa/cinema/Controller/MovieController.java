package com.qa.cinema.Controller;

import com.qa.cinema.domain.Booking;
import com.qa.cinema.domain.Movie;
import com.qa.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Listing")
public class MovieController {

    @Autowired
    MovieService service;

    @Autowired
    public MovieController(MovieService Service) {
        this.service = Service;
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movie>> getMovie() {
        List<Movie> movieData = this.service.readAllMovies();

        return new ResponseEntity<List<Movie>>(movieData, HttpStatus.OK);
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Movie> getMovieByID(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.readMovie(id));
    }

}
