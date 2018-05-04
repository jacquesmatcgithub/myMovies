package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.themoviedb.credits.Cast;
import org.themoviedb.credits.CastItem;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreditsTmdbTest {

    @Test
    void findCredits() {
        CreditsTmdb creditsTmdb = new CreditsTmdb();
        Cast cast = creditsTmdb.findCredits(
                "25da234db00ce6d226e5bc0072b39a02",
                "https://api.themoviedb.org/3/movie/",
                335984);

        List<CastItem> castItems = cast.getCast();
        String mainActor = castItems.get(0).getName();
        String testActor = "Ryan Gosling";

        assertEquals(testActor, mainActor);

    }
}