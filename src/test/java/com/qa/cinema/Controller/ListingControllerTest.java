package com.qa.cinema.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.qa.cinema.domain.Listing;
import com.qa.cinema.service.MovieService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ListingController.class})
@ExtendWith(SpringExtension.class)
class ListingControllerTest {
    @Autowired
    private ListingController listingController;

    @MockBean
    private MovieService movieService;

    @Test
    void testGetMovie() throws Exception {
        when(movieService.readAllMovies()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Listing/getAllMovies");
        MockMvcBuilders.standaloneSetup(listingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetMovie2() throws Exception {
        when(movieService.readAllMovies()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Listing/getAllMovies");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(listingController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetMovieByID() throws Exception {
        Listing listing = new Listing();
        listing.setActors("Actors");
        listing.setDirector("Director");
        listing.setMovieID(1L);
        listing.setMovieTitle("Ghostbusters");
        listing.setShowingTimes(11L);
        when(movieService.readMovie((Long) any())).thenReturn(listing);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Listing/getMovie/{id}", 123L);
        MockMvcBuilders.standaloneSetup(listingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"movieID\":1,\"movieTitle\":\"Ghostbusters\",\"director\":\"Director\",\"actors\":\"Actors\",\"showingTimes\":11}"));
    }
}

