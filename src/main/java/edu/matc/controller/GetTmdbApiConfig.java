package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.config.TmdbConfigConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * This class calls the movie database api to obtain the latest configuration data. We do this because tmdb
 * changes their base configurations from time to time.
 */
public class GetTmdbApiConfig {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GetTmdbApiConfig() {
    }

    public String getTmdbApiBaseUrl(String tmdbConfigUrl, String tmdbApiKey) {
        logger.debug("tmdbConfigUrl:" + tmdbConfigUrl);
        logger.debug("tmdbApiKey:" + tmdbApiKey);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(tmdbConfigUrl + tmdbApiKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            TmdbConfigConfig tmdbConfigConfig = mapper.readValue(response, TmdbConfigConfig.class);
            return tmdbConfigConfig.getTmdbConfigImages().getBaseUrl();
        } catch (IOException e) {
            return "Service Down";
        }
    }
}
