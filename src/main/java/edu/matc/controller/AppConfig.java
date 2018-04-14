package edu.matc.controller;

import edu.matc.entity.MetadataTmdb;
import edu.matc.persistence.MetadataTmdbDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * The type App config.
 */
public class AppConfig {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final static String SERVICE_DOWN = "Service Down";

    private String tmdbApiKey;
    private String tmdbConfigUrl;
    private String tmdbSearchUrl;
    private String tmdbQueryUrl;
    private String tmdbCreditsUrl;

    private Properties properties;


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
     * Instantiates a new App config.
     *
     * @param tmdbApiKey    the tmdb api key
     * @param tmdbConfigUrl the tmdb configuration url
     * @param tmdbSearchUrl the tmdb search url
     * @param tmdbQueryUrl  the tmdb get movie info url
     */
    public AppConfig(String tmdbApiKey, String tmdbConfigUrl, String tmdbSearchUrl, String tmdbQueryUrl) {
        this.tmdbApiKey = tmdbApiKey;
        this.tmdbConfigUrl = tmdbConfigUrl;
        this.tmdbSearchUrl = tmdbSearchUrl;
        this.tmdbQueryUrl = tmdbQueryUrl;
    }

    /**
     * Gets tmdb api key.
     *
     * @return the tmdb api key
     */
    public String getTmdbApiKey() {
        return tmdbApiKey;
    }

    /**
     * Sets tmdb api key.
     *
     * @param tmdbApiKey the tmdb api key
     */
    public void setTmdbApiKey(String tmdbApiKey) {
        this.tmdbApiKey = tmdbApiKey;
    }

    /**
     * Gets tmdb configuration url.
     *
     * @return the tmdb configuration url
     */
    public String getTmdbConfigUrl() {
        return tmdbConfigUrl;
    }

    /**
     * Sets tmdb configuration url.
     *
     * @param tmdbConfigUrl the tmdb configuration url
     */
    public void setTmdbConfigUrl(String tmdbConfigUrl) {
        this.tmdbConfigUrl = tmdbConfigUrl;
    }

    /**
     * Gets tmdb search url.
     *
     * @return the tmdb search url
     */
    public String getTmdbSearchUrl() {
        return tmdbSearchUrl;
    }

    /**
     * Sets tmdb search url.
     *
     * @param tmdbSearchUrl the tmdb search url
     */
    public void setTmdbSearchUrl(String tmdbSearchUrl) {
        this.tmdbSearchUrl = tmdbSearchUrl;
    }

    /**
     * Gets tmdb get movie info url.
     *
     * @return the tmdb get movie info url
     */
    public String getTmdbQueryUrl() {
        return tmdbQueryUrl;
    }

    /**
     * Sets tmdb get movie info url.
     *
     * @param tmdbQueryUrl the tmdb get movie info url
     */
    public void setTmdbQueryUrl(String tmdbQueryUrl) {
        this.tmdbQueryUrl = tmdbQueryUrl;
    }


    /**
     * Gets tmdb credits url.
     *
     * @return the tmdb credits url
     */
    public String getTmdbCreditsUrl() {
        return tmdbCreditsUrl;
    }

    /**
     * Sets tmdb credits url.
     *
     * @param tmdbCreditsUrl the tmdb credits url
     */
    public void setTmdbCreditsUrl(String tmdbCreditsUrl) {
        this.tmdbCreditsUrl = tmdbCreditsUrl;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppConfig appConfig = (AppConfig) o;
        return Objects.equals(tmdbApiKey, appConfig.tmdbApiKey) &&
                Objects.equals(tmdbConfigUrl, appConfig.tmdbConfigUrl) &&
                Objects.equals(tmdbSearchUrl, appConfig.tmdbSearchUrl) &&
                Objects.equals(tmdbQueryUrl, appConfig.tmdbQueryUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tmdbApiKey, tmdbConfigUrl, tmdbSearchUrl, tmdbQueryUrl);
    }

    /**
     * The loadProperties method loads myMovies.properties into session attributes
     * @param session
     */
    private void loadProperties(HttpSession session) {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/myMovies.properties"));

            //TODO What if some of the configuration elements are null?
            String tmdbApiKey = properties.getProperty("tmdb.api.key");
            String tmdbConfigUrl = properties.getProperty("tmdb.config.url");
            String tmdbSearchUrl = properties.getProperty("tmdb.search.url");
            String tmdbQueryUrl = properties.getProperty("tmdb.query.url");
            String tmdbCreditsUrl = properties.getProperty("tmdb.credits.url");

            setTmdbApiKey(tmdbApiKey);
            setTmdbConfigUrl(tmdbConfigUrl);
            setTmdbSearchUrl(tmdbSearchUrl);
            setTmdbQueryUrl(tmdbQueryUrl);
            setTmdbCreditsUrl(tmdbCreditsUrl);

            logger.debug("tmdbApiKey:" + getTmdbApiKey());
            logger.debug("tmdbConfigUrl:" + getTmdbConfigUrl());
            logger.debug("tmdbSearchUrl:" + getTmdbSearchUrl());
            logger.debug("tmdbQueryUrl:" + getTmdbQueryUrl());
            logger.debug("tmdbCreditsUrl:" + getTmdbCreditsUrl());

            session.setAttribute("tmdb.api.key", tmdbApiKey);
            session.setAttribute("tmdb.config.url", tmdbConfigUrl);
            session.setAttribute("tmdb.search.url", tmdbSearchUrl);
            session.setAttribute("tmdb.query.url", tmdbQueryUrl);
            session.setAttribute("tmdb.credits.url", tmdbCreditsUrl);

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
