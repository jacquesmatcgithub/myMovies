package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class TmdbJsonServiceTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Test
    void getConfigurationTest() {
        // create the object that has the method we want to test
        TmdbJsonService test = new TmdbJsonService();

        // create variable for th expected value
        String testValue = "http://image.tmdb.org/t/p/";

        // call the method and get the actual value
        String actualValue = "";
        try {
            actualValue = test.getConfiguration();
        } catch (MalformedURLException m) {
            logger.error("MalformedURLException", m);
        }

        // compare the two, pass of fail
        assertEquals(testValue, actualValue);
    }

    @Test
    void searchMoviesTest() {
        // create the object that has the method we want to test
        TmdbJsonService test = new TmdbJsonService();

        // create variable for th expected value
        int testValue = 10;

        // call the method and get the actual value
        int actualValue = 0;
        try {
            actualValue = test.searchMovies();
        } catch (MalformedURLException m) {
            logger.error("MalformedURLException", m);
        }

        // compare the two, pass of fail
        assertEquals(testValue, actualValue);

    }
    @Test
    void findSpecificMovieTest() {
        // create the object that has the method we want to test
        TmdbJsonService test = new TmdbJsonService();

        // create variable for th expected value
        int testValue = 10;

        // call the method and get the actual value
        int actualValue = 0;
        try {
            actualValue = test.findSpecificMovie();
        } catch (MalformedURLException m) {
            logger.error("MalformedURLException", m);
        }

        // compare the two, pass of fail
        assertEquals(testValue, actualValue);

    }
}