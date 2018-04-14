package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.credits.Cast;
import org.themoviedb.query.TmdbQueryResults;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * The QueryTmdb class is used to search for a movie on the movie database.
 */
public class CreditsTmdb {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     *
     */
    public CreditsTmdb() {
    }



    /**
     *
     * @param tmdbApiKey
     * @param tmdbCreditsUrl
     * @param movieId
     * @return
     */
    public Cast findCredits(String tmdbApiKey,
                            String tmdbCreditsUrl,
                            int movieId) {

        Cast cast = null;
        try {
            logger.debug("tmdbApiKey:" + tmdbApiKey);
            logger.debug("tmdbCreditsUrl:" + tmdbCreditsUrl);
            logger.debug("movieId:" + movieId);

            cast = getJsonResponse(tmdbApiKey, tmdbCreditsUrl, movieId);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cast;
    }



    /**
     *
     * @param tmdbApiKey
     * @param tmdbCreditsUrl
     * @param movieId
     * @return
     * @throws IOException
     */
    private Cast getJsonResponse(String tmdbApiKey,
                                 String tmdbCreditsUrl,
                                 int movieId) throws IOException {

        String tmdbUrl = tmdbCreditsUrl + movieId + "/credits?api_key=" + tmdbApiKey;

        logger.debug("tmdbUrl:" + tmdbUrl);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(tmdbUrl);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, Cast.class);
    }
}
