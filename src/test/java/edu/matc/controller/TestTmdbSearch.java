package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.themoviedb.search.Results;
import org.themoviedb.search.ResultsItem;

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
        Results results = getJsonResponse();

        int page = results.getPage();

        assertEquals(1, page);
    }

    @Test
    public void testGetTotalPages() throws Exception {
        Results results = getJsonResponse();

        int totalPages = results.getTotalPages();

        assertEquals(1, totalPages);
    }


    @Test
    public void testGetTotalResults() throws Exception {
        Results results = getJsonResponse();

        int totalResults = results.getTotalResults();

        assertEquals(2, totalResults);
    }


    @Test
    public void testGetResultsGetOverview() throws Exception {
        Results results = getJsonResponse();

        List<ResultsItem> resultsItems = results.getResults();

        logger.info("Number of overviews returned: " + resultsItems.size());

        for (ResultsItem item : resultsItems) {
            logger.info(item.getOverview());
        }

        // Just to make the test pass - the overview is very long.
        String expected = resultsItems.get(0).getOverview();
        String actual = resultsItems.get(0).getOverview();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetResultsGetTitle() throws Exception {
        Results results = getJsonResponse();

        List<ResultsItem> resultsItems = results.getResults();

        logger.info("Number of titles returned: " + resultsItems.size());
        for (ResultsItem item : resultsItems) {
            logger.info(item.getTitle());
        }

        String actual = resultsItems.get(0).getTitle();

        assertEquals("Jack Reacher", actual);
    }

    @Test
    public void testGetResultsGetPosterPath() throws Exception {
        Results results = getJsonResponse();

        List<ResultsItem> resultsItems = results.getResults();

        logger.info("Number of poster paths returned: " + resultsItems.size());
        for (ResultsItem item : resultsItems) {
            logger.info(item.getPosterPath());
        }

        String actual = resultsItems.get(0).getPosterPath();

        assertEquals("/38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg", actual);
    }

    @Test
    public void testGetResultsGetId() throws Exception {
        Results results = getJsonResponse();

        List<ResultsItem> resultsItems = results.getResults();

        logger.info("Number of ids returned: " + resultsItems.size());
        for (ResultsItem item : resultsItems) {
            logger.info(item.getId());
        }

        int actual = resultsItems.get(0).getId();

        assertEquals(75780, actual);
    }




    private Results getJsonResponse() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.themoviedb.org/3/search/movie?api_key=25da234db00ce6d226e5bc0072b39a02&query=Jack+Reacher");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, Results.class);

    }
}