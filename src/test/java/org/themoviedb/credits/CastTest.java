package org.themoviedb.credits;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.themoviedb.search.TmdbSearchResults;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CastTest {

    @Test
    void setCast()  throws IOException {

    }

    @Test
    void getCast()  throws IOException {
        Cast cast = getJsonResponse();

        List<CastItem> castList = cast.getCast();

        String castMember = castList.get(0).getName();
        String compareString = castMember;

        assertEquals(compareString, castMember);
    }

    @Test
    void setId()  throws IOException {
    }

    @Test
    void getId()  throws IOException {
    }

    @Test
    void setCrew()  throws IOException {
    }

    @Test
    void getCrew() throws IOException {
        Cast cast = getJsonResponse();

        List<CrewItem> crewList = cast.getCrew();

        String crewMember = crewList.get(0).getName();
        String compareString = crewMember;

        assertEquals(compareString, crewMember);

    }


    private Cast getJsonResponse() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.themoviedb.org/3/movie/75780/credits?api_key=25da234db00ce6d226e5bc0072b39a02");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, Cast.class);

    }

}