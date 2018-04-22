package edu.matc.controller;

import edu.matc.entity.MetadataTmdb;
import edu.matc.persistence.MetadataTmdbDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

/**
 * The type App config.
 */
public class AppConfig {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final static String SERVICE_DOWN = "Service Down";

    /**
     * Instantiates a new App config.
     */
    public AppConfig() {
    }

    /**
     * Instantiates a new App config.
     *
     * @param request the request
     */
    public AppConfig(HttpServletRequest request) {
        HttpSession session = request.getSession();

        loadProperties(session);
        loadMetaData(session);
    }

    /**
     * The loadProperties method loads myMovies.properties into session attributes
     * @param session
     */
    private void loadProperties(HttpSession session) {
        Properties properties;

        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/myMovies.properties"));

            //TODO What if some of the configuration elements are null?

            // Load The Movie Database properties
            String tmdbApiKey = properties.getProperty("tmdb.api.key");
            String tmdbConfigUrl = properties.getProperty("tmdb.config.url");
            String tmdbSearchUrl = properties.getProperty("tmdb.search.url");
            String tmdbQueryUrl = properties.getProperty("tmdb.query.url");
            String tmdbCreditsUrl = properties.getProperty("tmdb.credits.url");

            session.setAttribute("tmdb.api.key", tmdbApiKey);
            session.setAttribute("tmdb.config.url", tmdbConfigUrl);
            session.setAttribute("tmdb.search.url", tmdbSearchUrl);
            session.setAttribute("tmdb.query.url", tmdbQueryUrl);
            session.setAttribute("tmdb.credits.url", tmdbCreditsUrl);



            // Load The Weather Underground properties
            String wundergroundApiKey = properties.getProperty("wunderground.api.key");
            String wundergroundConditionsUrl = properties.getProperty("wunderground.conditions.url");
            String wundergroundIconUrl = properties.getProperty("wunderground.icon.url");
            String wundergroundForecastUrl = properties.getProperty("wunderground.forecast.url");

            session.setAttribute("wunderground.api.key", wundergroundApiKey);
            session.setAttribute("wunderground.conditions.url", wundergroundConditionsUrl);
            session.setAttribute("wunderground.icon.url", wundergroundIconUrl);
            session.setAttribute("wunderground.forecast.url", wundergroundForecastUrl);

        } catch (IOException ioe) {
            logger.error("AppConfig.loadProperties()...Cannot load the properties file", ioe);
        } catch (Exception e) {
            logger.error("AppConfig.loadProperties()...",  e);
        }
    }


    /**
     * The loadMetaData method selects from the metadata_tmdb table. It also
     * instantates a GetTmdbApiConfig object that calls the movie database api
     * to get the latest configuration settings. It then stores the metadata
     * values as session attributes.
     * @param session
     */
    private void loadMetaData(HttpSession session) {
        // Get the latest configuration by caling the tmdb api
        GetTmdbApiConfig getTmdbConfig = new GetTmdbApiConfig();
        String apiBaseUrlTmdb  = getTmdbConfig.getTmdbApiBaseUrl(
                (String)session.getAttribute("tmdb.config.url"),
                (String)session.getAttribute("tmdb.api.key"));

//TODO What if the movie database api is down?
//        if (apiBaseUrlTmdb.equals(SERVICE_DOWN)) {
//            baseUrlTmdb = metadataTmdb.getBaseUrl();
//        } else {
//
//        }


        // Get the configuration data currently stored on the metadata_tmdb table
        MetadataTmdbDao metadataMetadataTmdbDao = new MetadataTmdbDao();
        MetadataTmdb metadataTmdb = metadataMetadataTmdbDao.getById(1); // There is always only 1 row on this table
        String storedBaseUrlTmdb = metadataTmdb.getBaseUrl();

        // If the api and stored base urls are the same, or the api is down, set the session attribute
        // to what was stored on the metadata_tmdb table. Otherwise, set the session attribute to what
        // the api returned and also update the metadata_tmdb table with the new base url.
        if (apiBaseUrlTmdb.equals(storedBaseUrlTmdb) || apiBaseUrlTmdb.equals(SERVICE_DOWN)) {
            session.setAttribute("baseUrlTmdb", storedBaseUrlTmdb);
        } else {
            metadataTmdb.setBaseUrl(apiBaseUrlTmdb);
            metadataMetadataTmdbDao.saveOrUpdate(metadataTmdb);
        }

        session.setAttribute("logoSizeTmdb", metadataTmdb.getLogoSize());
        session.setAttribute("backdropSizeTmdb", metadataTmdb.getBackdropSize());
    }
}
