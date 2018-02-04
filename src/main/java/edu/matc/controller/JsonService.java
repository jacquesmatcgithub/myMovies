package edu.matc.controller;
import edu.matc.persistence.*;
import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class JsonService {

    private String apikey;

    private Client client;
    private WebTarget target;

    @PostConstruct
    protected void init() {
        client = ClientBuilder.newClient();
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric
        target = client.target(
                "http://api.openweathermap.org/data/2.5/forecast/daily").queryParam("cnt", "10")
                .queryParam("mode", "json")
                .queryParam("units", "metric")
                .queryParam("appid", apikey)
        ;
    }

    // The ForecastResponse is the bean that holds the weather info
    public ForecastResponse getForecast(String place) {
        return target.queryParam("q", place)
                .request(MediaType.APPLICATION_JSON)
                .get(ForecastResponse.class);
    }
}
