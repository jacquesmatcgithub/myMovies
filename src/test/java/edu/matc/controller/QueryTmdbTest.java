package edu.matc.controller;

import org.junit.jupiter.api.Test;
import org.themoviedb.query.TmdbQueryResults;

import static org.junit.jupiter.api.Assertions.*;

class QueryTmdbTest {

    @Test
    void findMovie() {
        QueryTmdb queryTmdb = new QueryTmdb();
        TmdbQueryResults results = queryTmdb.findMovie(
                "25da234db00ce6d226e5bc0072b39a02",
                "https://api.themoviedb.org/3/movie/",
                        500);

        String actualTitle = results.getOriginalTitle();
        String testTitle = "Reservoir Dogs";

        assertEquals(testTitle, actualTitle);

    }
}