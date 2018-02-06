package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class TmdbJsonService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public int readTmdbApi() throws MalformedURLException {
        logger.info("-------------------------------------------------------------------------");
        URL url = new URL("https://api.themoviedb.org/3/configuration?api_key=25da234db00ce6d226e5bc0072b39a02");

        try (InputStream is = url.openStream(); JsonParser parser = Json.createParser(is)) {
            while (parser.hasNext()) {
                JsonParser.Event e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {
                    logger.info(parser.getString());
                    switch (parser.getString()) {
                        case "base_url":
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
