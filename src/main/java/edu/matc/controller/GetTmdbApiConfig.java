package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.config.Config;

import javax.servlet.http.HttpSession;
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
        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("https://api.themoviedb.org/3/configuration?api_key=" + tmdbApiKey);
        WebTarget target = client.target(tmdbConfigUrl + tmdbApiKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            Config config = mapper.readValue(response, Config.class);
            return config.getImages().getBaseUrl();
        } catch (IOException e) {
            return "Service Down";
        }
    }
}
