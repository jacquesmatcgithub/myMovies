package edu.matc.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetTmdbConfigTest {

    @Test
    void getTmdbBaseUrl() {
        GetTmdbApiConfig getTmdbConfig = new GetTmdbApiConfig();

        String expectedUrl = "http://image.tmdb.org/t/p/";
        String actualUrl = getTmdbConfig.getTmdbApiBaseUrl("https://api.themoviedb.org/3/configuration?api_key=","25da234db00ce6d226e5bc0072b39a02");

        assertEquals(expectedUrl, actualUrl);

    }
}