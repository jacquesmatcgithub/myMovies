package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class TmdbJsonService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public String getConfiguration() throws MalformedURLException {
        logger.info("-------------------------------------------------------------------------");
        logger.info("- getConfiguration -");
        logger.info("-------------------------------------------------------------------------");
        URL url = new URL("https://api.themoviedb.org/3/configuration?api_key=25da234db00ce6d226e5bc0072b39a02");

        try (InputStream inputStream = url.openStream();
             JsonParser parser = Json.createParser(inputStream)) {
            while (parser.hasNext()) {
                JsonParser.Event e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {
                    switch (parser.getString()) {
                        case "base_url":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            return parser.getString();
                    }
                }
            }
        } catch (IOException io) {
            logger.error("IOException", io);
        }
        return "";
    }


    public int searchMovies() throws MalformedURLException  {
        logger.info("-------------------------------------------------------------------------");
        logger.info("- searchMovies -");
        logger.info("-------------------------------------------------------------------------");
        URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=25da234db00ce6d226e5bc0072b39a02&query=Jack+Reacher");

        try (InputStream inputStream = url.openStream();
             JsonParser parser = Json.createParser(inputStream)) {
            JsonParser.Event e;
            while (parser.hasNext()) {
                e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {

                    switch (parser.getString()) {
                        case "total_results":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                        case "id":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                        case "title":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                    }
                }

            }
        } catch (IOException io) {
            logger.error("IOException", io);
        }
        return 10;

    }


    public int findSpecificMovie() throws MalformedURLException  {
        logger.info("-------------------------------------------------------------------------");
        logger.info("- findSpecificMovie -");
        logger.info("-------------------------------------------------------------------------");
        URL url = new URL("https://api.themoviedb.org/3/movie/75780?api_key=25da234db00ce6d226e5bc0072b39a02");

        try (InputStream inputStream = url.openStream();
             JsonParser parser = Json.createParser(inputStream)) {
            JsonParser.Event e;
            while (parser.hasNext()) {
                e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {

                    switch (parser.getString()) {
                        case "id":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                        case "title":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                        case "poster_path":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                        case "overview":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                    }
                }

            }
        } catch (IOException io) {
            logger.error("IOException", io);
        }
        return 10;
    }




    public int getConfigurationWithArrays() throws MalformedURLException {
        logger.info("-------------------------------------------------------------------------");
        logger.info("- getConfigurationWithArrays -");
        logger.info("-------------------------------------------------------------------------");
        URL url = new URL("https://api.themoviedb.org/3/configuration?api_key=25da234db00ce6d226e5bc0072b39a02");

        try (InputStream inputStream = url.openStream();
             JsonParser parser = Json.createParser(inputStream)) {
            while (parser.hasNext()) {
                JsonParser.Event e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {
                    switch (parser.getString()) {
                        case "base_url":
                            logger.info(parser.getString());
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                        case "secure_base_url":
                            parser.next();
                            logger.info("  " + parser.getString());
                            break;
                        case "backdrop_sizes":
                             parseArray(parser);
                            break;
                        case "logo_sizes":
                            parseArray(parser);
                            break;
                        case "poster_sizes":
                            parseArray(parser);
                            break;
                        case "profile_sizes":
                            parseArray(parser);
                            break;
                        case "still_sizes":
                            parseArray(parser);
                            break;
                        case "change_keys":
                            parseArray(parser);
                            break;
                    }
                }
            }
        } catch (IOException io) {
            logger.error("IOException", io);
        }
        return 10;
    }
    /**
     * The parseArray method parses a JsonParser object and returns it's items as a map of strings.
     * @param parser
     */
    private void parseArray(JsonParser parser) {
        JsonParser.Event e = parser.next();
        if (e == JsonParser.Event.START_ARRAY) {
            e = parser.next();
            while (e != JsonParser.Event.END_ARRAY) {
                logger.info("  " + parser.getString());
                e = parser.next();
            }
        }
    }
}
