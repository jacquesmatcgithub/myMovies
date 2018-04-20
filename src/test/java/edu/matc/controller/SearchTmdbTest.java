package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.themoviedb.search.TmdbSearchResults;
import org.themoviedb.search.TmdbSearchResultsItem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTmdbTest {
    private final Logger logger = LogManager.getLogger(this.getClass());


    @Test
    void findMovie() {
        TmdbSearchResults tmdbSearchResults = new TmdbSearchResults();

        SearchTmdb searchTmdb = new SearchTmdb();

        tmdbSearchResults = searchTmdb.findMovie("25da234db00ce6d226e5bc0072b39a02",
                "https://api.themoviedb.org/3/search/movie",
                "jack reacher");

        List<TmdbSearchResultsItem> tmdbSearchResultsItems = tmdbSearchResults.getResults();

        for (TmdbSearchResultsItem item : tmdbSearchResultsItems) {
            logger.debug("id:" + item.getId() + "   Title:" + item.getTitle());
        }


    }
}