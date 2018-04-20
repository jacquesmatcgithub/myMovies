package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.search.TmdbSearchResults;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * The QueryTmdb class is used to search for a movie on the movie database.
 */
public class SearchTmdb {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     *
     */
    public SearchTmdb() {
    }

    /**
     *
     * @param tmdbApiKey
     * @param tmdbSearchUrl
     * @param movieName
     * @return
     */
    public TmdbSearchResults findMovie(String tmdbApiKey,
                                       String tmdbSearchUrl,
                                       String movieName) {

        TmdbSearchResults tmdbSearchResults = null;
        try {
            logger.debug("tmdbApiKey:" + tmdbApiKey);
            logger.debug("tmdbSearchUrl:" + tmdbSearchUrl);
            logger.debug("movieName:" + movieName);

            tmdbSearchResults = getJsonResponse(tmdbApiKey, tmdbSearchUrl, movieName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tmdbSearchResults;
    }


    /**
     *
     * @param tmdbApiKey
     * @param tmdbSearchUrl
     * @param movieName
     * @return
     * @throws IOException
     */
    private TmdbSearchResults getJsonResponse(String tmdbApiKey,
                                             String tmdbSearchUrl,
                                             String movieName) throws IOException {

        String tmdbUrl = tmdbSearchUrl +
                "?api_key=" + tmdbApiKey +
                "&query=" + URLEncoder.encode(movieName, "UTF-8") +
                "&include_adult=false";

        logger.debug("tmdbUrl:" + tmdbUrl);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(tmdbUrl);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, TmdbSearchResults.class);
    }
}
