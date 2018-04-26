package com.wunderground.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class Wunderground {


    private final Logger logger = LogManager.getLogger(this.getClass());

    public Wunderground() {

    }

/*
    wunderground.api.key = bbb31fc503e799ce
    wunderground.conditions.url = http://api.wunderground.com/api/{wunderApiKey}/conditions/q/{state}/{city}.json
    wunderground.icon.path = http://icons.wxug.com/i/c/k/{iconName}.gif
*/

    public WeatherResponse getCurrentConditions(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");

        UserDao userDao = new UserDao();
        List<User> users = userDao.getByPropertyEqual("loginId", currentUser);
        String city = users.get(0).getCity();
        String state = users.get(0).getState();

        city = URLEncoder.encode(city, "UTF-8");
        state = URLEncoder.encode(state, "UTF-8");

        String wundergroundApiKey = (String)session.getAttribute("wunderground.api.key");
        String wundergroundConditionsUrl = (String)session.getAttribute("wunderground.conditions.url");

        wundergroundConditionsUrl = wundergroundConditionsUrl.replace("{wunderApiKey}", wundergroundApiKey);
        wundergroundConditionsUrl = wundergroundConditionsUrl.replace("{state}", state);
        wundergroundConditionsUrl = wundergroundConditionsUrl.replace("{city}", city);
        logger.debug("wundergroundConditionsUrl:", wundergroundConditionsUrl);

        return getJsonResponse(wundergroundConditionsUrl);
    }


    private WeatherResponse getJsonResponse(String wundergroundConditionsUrl) throws IOException {

        logger.debug("wundergroundConditionsUrl:" + wundergroundConditionsUrl);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(wundergroundConditionsUrl);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response, WeatherResponse.class);

    }
}