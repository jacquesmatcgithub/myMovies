package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.query.TmdbQueryResults;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * The QueryTmdb class is used to search for a movie on the movie database.
 */
public class QueryTmdb {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     *
     */
    public QueryTmdb() {
    }



    /**
     *
     * @param tmdbApiKey
     * @param tmdbQueryUrl
     * @param movieId
     * @return
     */
    public TmdbQueryResults findMovie(String tmdbApiKey,
                                      String tmdbQueryUrl,
                                      int movieId) {

        TmdbQueryResults tmdbQueryResults = null;
        try {
            logger.debug("tmdbApiKey:" + tmdbApiKey);
            logger.debug("tmdbQueryUrl:" + tmdbQueryUrl);
            logger.debug("movieId:" + movieId);

            tmdbQueryResults = getJsonResponse(tmdbApiKey, tmdbQueryUrl, movieId);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tmdbQueryResults;
    }



    /**
     *
     * @param tmdbApiKey
     * @param tmdbQueryUrl
     * @param movieId
     * @return
     * @throws IOException
     */
    private TmdbQueryResults getJsonResponse(String tmdbApiKey,
                                             String tmdbQueryUrl,
                                             int movieId) throws IOException {

        String tmdbUrl = tmdbQueryUrl + movieId + "?api_key=" + tmdbApiKey;

        logger.debug("tmdbUrl:" + tmdbUrl);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(tmdbUrl);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, TmdbQueryResults.class);
    }
}
