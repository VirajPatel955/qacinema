package com.qa.cinema.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.qa.cinema.domain.Listing;
import com.qa.cinema.repo.MovieRepo;

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

@ContextConfiguration(classes = {MovieService.class})
@ExtendWith(SpringExtension.class)
class MovieServiceTest {
    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private MovieRepo movieRepo;

    @Autowired
    private MovieService movieService;

    @Test
    void testReadMovie() {
        Listing listing = new Listing();
        listing.setActors("Actors");
        listing.setDirector("Director");
        listing.setMovieID(1L);
        listing.setMovieTitle("Ghostbusters");
        listing.setShowingTimes(1L);
        Optional<Listing> ofResult = Optional.of(listing);
        when(movieRepo.findById((Long) any())).thenReturn(ofResult);
        assertSame(listing, movieService.readMovie(123L));
        verify(movieRepo).findById((Long) any());
    }


    @Test
    void testReadAllMovies() {
        ArrayList<Listing> listingList = new ArrayList<>();
        when(movieRepo.findAll()).thenReturn(listingList);
        List<Listing> actualReadAllMoviesResult = movieService.readAllMovies();
        assertSame(listingList, actualReadAllMoviesResult);
        assertTrue(actualReadAllMoviesResult.isEmpty());
        verify(movieRepo).findAll();
    }
}

