package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.persistence.MovieDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CleanupUserMovieCatalogTest {

    @Test
    void deleteNonCatalogMovies() {


        CleanupUserMovieCatalog cleanup = new CleanupUserMovieCatalog();
        cleanup.deleteNonCatalogMovies("jfourie");

        MovieDao movieDao = new MovieDao();
        List<Movie> movies = movieDao.getByPropertyEqual("movieState", "SR");
        assertEquals(0, movies.size());

        movies = movieDao.getByPropertyEqual("movieState", "SC");
        assertEquals(0, movies.size());

        movies = movieDao.getByPropertyEqual("movieState", "SU");
        assertEquals(0, movies.size());

    }
}