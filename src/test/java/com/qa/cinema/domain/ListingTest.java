package com.qa.cinema.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ListingTest {

    @Test
    void testConstructor() {
        Listing actualMovie = new Listing();
        actualMovie.setActors("Actors");
        actualMovie.setDirector("Director");
        actualMovie.setMovieID(1L);
        actualMovie.setMovieTitle("Ghostbusters");
        actualMovie.setShowingTimes(11L);
        String actualToStringResult = actualMovie.toString();
        assertEquals("Actors", actualMovie.getActors());
        assertEquals("Director", actualMovie.getDirector());
        assertEquals(1L, actualMovie.getMovieID().longValue());
        assertEquals("Ghostbusters", actualMovie.getMovieTitle());
        assertEquals(11L, actualMovie.getShowingTimes().longValue());
        assertEquals("Movie{movieID=1, movieTitle='Ghostbusters', director='Director', actors='Actors', showingTimes=11}",
                actualToStringResult);
    }

    @Test
    void testConstructor2() {
        Listing actualMovie = new Listing(1L, "Ghostbusters", "Director", "Actors", 11L);
        actualMovie.setActors("Actors");
        actualMovie.setDirector("Director");
        actualMovie.setMovieID(1L);
        actualMovie.setMovieTitle("Ghostbusters");
        actualMovie.setShowingTimes(11L);
        String actualToStringResult = actualMovie.toString();
        assertEquals("Actors", actualMovie.getActors());
        assertEquals("Director", actualMovie.getDirector());
        assertEquals(1L, actualMovie.getMovieID().longValue());
        assertEquals("Ghostbusters", actualMovie.getMovieTitle());
        assertEquals(11L, actualMovie.getShowingTimes().longValue());
        assertEquals("Movie{movieID=1, movieTitle='Ghostbusters', director='Director', actors='Actors', showingTimes=11}",
                actualToStringResult);
    }

    @Test
    void testConstructor3() {
        Listing actualMovie = new Listing("Ghostbusters", "Director", "Actors", 11L);
        actualMovie.setActors("Actors");
        actualMovie.setDirector("Director");
        actualMovie.setMovieID(1L);
        actualMovie.setMovieTitle("Ghostbusters");
        actualMovie.setShowingTimes(11L);
        String actualToStringResult = actualMovie.toString();
        assertEquals("Actors", actualMovie.getActors());
        assertEquals("Director", actualMovie.getDirector());
        assertEquals(1L, actualMovie.getMovieID().longValue());
        assertEquals("Ghostbusters", actualMovie.getMovieTitle());
        assertEquals(11L, actualMovie.getShowingTimes().longValue());
        assertEquals("Movie{movieID=1, movieTitle='Ghostbusters', director='Director', actors='Actors', showingTimes=11}",
                actualToStringResult);
    }

    @Test
    void testEquals() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector("Director");
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(11L);
        assertNotEquals(movie, null);
    }

    @Test
    void testEquals2() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector("Director");
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(11L);
        assertNotEquals(movie, "Different type to Movie");
    }

    @Test
    void testEquals3() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector("Director");
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(11L);
        assertEquals(movie, movie);
        int expectedHashCodeResult = movie.hashCode();
        assertEquals(expectedHashCodeResult, movie.hashCode());
    }

    @Test
    void testEquals4() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector("Director");
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(11L);

        Listing movie1 = new Listing();
        movie1.setActors("Actors");
        movie1.setDirector("Director");
        movie1.setMovieID(1L);
        movie1.setMovieTitle("Ghostbusters");
        movie1.setShowingTimes(11L);
        assertEquals(movie, movie1);
        int expectedHashCodeResult = movie.hashCode();
        assertEquals(expectedHashCodeResult, movie1.hashCode());
    }

    @Test
    void testEquals5() {
        Listing movie = new Listing();
        movie.setActors(null);
        movie.setDirector("Director");
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(11L);

        Listing movie1 = new Listing();
        movie1.setActors("Actors");
        movie1.setDirector("Director");
        movie1.setMovieID(1L);
        movie1.setMovieTitle("Ghostbusters");
        movie1.setShowingTimes(11L);
        assertNotEquals(movie, movie1);
    }

    @Test
    void testEquals6() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector(null);
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(11L);

        Listing movie1 = new Listing();
        movie1.setActors("Actors");
        movie1.setDirector("Director");
        movie1.setMovieID(1L);
        movie1.setMovieTitle("Ghostbusters");
        movie1.setShowingTimes(11L);
        assertNotEquals(movie, movie1);
    }

    @Test
    void testEquals7() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector("Director");
        movie.setMovieID(0L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(11L);

        Listing movie1 = new Listing();
        movie1.setActors("Actors");
        movie1.setDirector("Director");
        movie1.setMovieID(1L);
        movie1.setMovieTitle("Ghostbusters");
        movie1.setShowingTimes(11L);
        assertNotEquals(movie, movie1);
    }

    @Test
    void testEquals8() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector("Director");
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghost");
        movie.setShowingTimes(1L);

        Listing movie1 = new Listing();
        movie1.setActors("Actors");
        movie1.setDirector("Director");
        movie1.setMovieID(1L);
        movie1.setMovieTitle("Ghostbusters");
        movie1.setShowingTimes(11L);
        assertNotEquals(movie, movie1);
    }

    @Test
    void testEquals9() {
        Listing movie = new Listing();
        movie.setActors("Actors");
        movie.setDirector("Director");
        movie.setMovieID(1L);
        movie.setMovieTitle("Ghostbusters");
        movie.setShowingTimes(0L);

        Listing movie1 = new Listing();
        movie1.setActors("Actors");
        movie1.setDirector("Director");
        movie1.setMovieID(1L);
        movie1.setMovieTitle("Ghostbusters");
        movie1.setShowingTimes(1L);
        assertNotEquals(movie, movie1);
    }
}

