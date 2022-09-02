package com.qa.cinema.Controller;

import com.qa.cinema.domain.Listing;
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
public class ListingController {

    @Autowired
    MovieService service;

    @Autowired
    public ListingController(MovieService Service) {
        this.service = Service;
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Listing>> getMovie() {
        List<Listing> movieData = this.service.readAllMovies();

        return new ResponseEntity<List<Listing>>(movieData, HttpStatus.OK);
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Listing> getMovieByID(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.readMovie(id));
    }

}
