package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.themoviedb.config.Config;
import org.themoviedb.config.Images;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This tester class tests the org.themoviedb.config classes
 */
public class TestTmdbConfig {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testTmdbConfigGetBaseUrl() throws Exception {
        Config config = getJsonResponse();

        String baseUrl = config.getImages().getBaseUrl();

        assertEquals("http://image.tmdb.org/t/p/", baseUrl);
    }

    @Test
    public void testTmdbConfigGetSecureBaseUrl() throws Exception {
        Config config = getJsonResponse();

        String secureBaseUrl = config.getImages().getSecureBaseUrl();

        assertEquals("https://image.tmdb.org/t/p/", secureBaseUrl);
    }


    @Test
    public void testTmdbGetPosterSizes() throws Exception {
        Config config = getJsonResponse();

        List<String> posterSizes = config.getImages().getPosterSizes();

        String allPosterSizes = "Number of posterSize array = " + posterSizes.size() + " :";
        for (String posterSize : posterSizes) {
            allPosterSizes += " " + posterSize;
        }
        logger.info(allPosterSizes);

        assertEquals("w92", posterSizes.get(0));
        assertEquals("w154", posterSizes.get(1));
        assertEquals("w185", posterSizes.get(2));
        assertEquals("w342", posterSizes.get(3));
        assertEquals("w500", posterSizes.get(4));
        assertEquals("w780", posterSizes.get(5));
        assertEquals("original", posterSizes.get(6));
    }




    private Config getJsonResponse() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.themoviedb.org/3/configuration?api_key=25da234db00ce6d226e5bc0072b39a02");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, Config.class);

    }
}