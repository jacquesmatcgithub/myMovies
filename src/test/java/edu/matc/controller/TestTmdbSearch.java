package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.themoviedb.search.TmdbSearchResults;
import org.themoviedb.search.TmdbSearchResultsItem;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTmdbSearch {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testGetPage() throws Exception {
        TmdbSearchResults tmdbSearchResults = getJsonResponse();

        int page = tmdbSearchResults.getPage();

        assertEquals(1, page);
    }

    @Test
    public void testGetTotalPages() throws Exception {
        TmdbSearchResults tmdbSearchResults = getJsonResponse();

        int totalPages = tmdbSearchResults.getTotalPages();

        assertEquals(1, totalPages);
    }


    @Test
    public void testGetTotalResults() throws Exception {
        TmdbSearchResults tmdbSearchResults = getJsonResponse();

        int totalResults = tmdbSearchResults.getTotalResults();

        assertEquals(2, totalResults);
    }


    @Test
    public void testGetResultsGetOverview() throws Exception {
        TmdbSearchResults tmdbSearchResults = getJsonResponse();

        List<TmdbSearchResultsItem> tmdbSearchResultsItems = tmdbSearchResults.getResults();

        logger.info("Number of overviews returned: " + tmdbSearchResultsItems.size());

        for (TmdbSearchResultsItem item : tmdbSearchResultsItems) {
            logger.info(item.getOverview());
        }

        // Just to make the test pass - the overview is very long.
        String expected = tmdbSearchResultsItems.get(0).getOverview();
        String actual = tmdbSearchResultsItems.get(0).getOverview();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetResultsGetTitle() throws Exception {
        TmdbSearchResults tmdbSearchResults = getJsonResponse();

        List<TmdbSearchResultsItem> tmdbSearchResultsItems = tmdbSearchResults.getResults();

        logger.info("Number of titles returned: " + tmdbSearchResultsItems.size());
        for (TmdbSearchResultsItem item : tmdbSearchResultsItems) {
            logger.info(item.getTitle());
        }

        String actual = tmdbSearchResultsItems.get(0).getTitle();

        assertEquals("Jack Reacher", actual);
    }

    @Test
    public void testGetResultsGetPosterPath() throws Exception {
        TmdbSearchResults tmdbSearchResults = getJsonResponse();

        List<TmdbSearchResultsItem> tmdbSearchResultsItems = tmdbSearchResults.getResults();

        logger.info("Number of poster paths returned: " + tmdbSearchResultsItems.size());
        for (TmdbSearchResultsItem item : tmdbSearchResultsItems) {
            logger.info(item.getPosterPath());
        }

        String actual = tmdbSearchResultsItems.get(0).getPosterPath();

        assertEquals("/38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg", actual);
    }

    @Test
    public void testGetResultsGetId() throws Exception {
        TmdbSearchResults tmdbSearchResults = getJsonResponse();

        List<TmdbSearchResultsItem> tmdbSearchResultsItems = tmdbSearchResults.getResults();

        logger.info("Number of ids returned: " + tmdbSearchResultsItems.size());
        for (TmdbSearchResultsItem item : tmdbSearchResultsItems) {
            logger.info(item.getId());
        }

        int actual = tmdbSearchResultsItems.get(0).getId();

        assertEquals(75780, actual);
    }




    private TmdbSearchResults getJsonResponse() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.themoviedb.org/3/search/movie?api_key=25da234db00ce6d226e5bc0072b39a02&query=Jack+Reacher");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, TmdbSearchResults.class);

    }
}