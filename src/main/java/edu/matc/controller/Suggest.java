package edu.matc.controller;

import com.wunderground.api.WeatherResponse;
import com.wunderground.api.Wunderground;
import edu.matc.entity.Movie;
import edu.matc.entity.ViewingHabit;
import edu.matc.persistence.MovieDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Suggest {

    private static final String SPRING = "Spring";
    private static final String SUMMER = "Summer";
    private static final String FALL = "Fall";
    private static final String WINTER = "Winter";

    public Suggest() {
    }

    public List<Movie> multipleMovies(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");

        // Get the current weather conditions
        WeatherResponse weatherResponse = getCurrentWeatherConditions(request);
        int localTemp = (int)weatherResponse.getCurrentObservation().getTempF();
        String weatherConditions = weatherResponse.getCurrentObservation().getWeather();

        // Get the current season
        LocalDate localDate = LocalDate.now();
        String currentSeason = getSeason(localDate);

        // Run through all the collector's movies and look at the viewing habit of each
        List<Movie> suggestedMovies = new ArrayList<>();
        Set<ViewingHabit> viewingHabits = null;
        ViewingHabit viewingHabit = null;
        MovieDao movieDao = new MovieDao();
        List<Movie> movies = movieDao.getByPropertyEqual("loginId", currentUser);

        for (Movie thisMovie : movies) {
            viewingHabits = thisMovie.getViewingHabits();

            if (!viewingHabits.isEmpty()) {
                if (evaluateViewingHabits(viewingHabits,
                        weatherConditions,
                        currentSeason,
                        localTemp)) {
                    suggestedMovies.add(thisMovie);
                }
            }
        }

        return suggestedMovies;
    }


    /**
     * The evaluateViewingHabits method will evaluate whether or not this movie
     * should be added to the suggested list of movies.
     * @param habits
     * @param weatherConditions
     * @param currentSeason
     * @param localTemp
     * @return
     */
    private boolean evaluateViewingHabits(Set<ViewingHabit> habits,
                                          String weatherConditions,
                                          String currentSeason,
                                          int localTemp) {
        List<ViewingHabit> viewingHabitList = new ArrayList<>(habits);

        // The viewing habits are sorted by date_watched in descending order,
        // putting the very latest viewing habit in the zero index.
        ViewingHabit habit = viewingHabitList.get(0);

        String habitSeason = getSeason(habit.getDateWatched());
        int habitTemp = habit.getTemp();
        String habitWeatherConditions = habit.getWeatherConditions();

        //TODO Enhance the weather condition matching
        if (currentSeason.equals(habitSeason) &&
                (localTemp - habitTemp <= 20) &&
                weatherConditions.equals(habitWeatherConditions)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * The getCurrentWeatherConditions method gets the current weather conditions
     * from the wunderground webservice.
     * @param request
     * @return
     */
    private WeatherResponse getCurrentWeatherConditions(HttpServletRequest request) {
        // Get the current weather conditions
        Wunderground wunderground = new Wunderground();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = wunderground.getCurrentConditions(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weatherResponse;
    }


    /**
     * The getSeason method returns the current season.
     * @param localDate
     * @return
     */
    private String getSeason(LocalDate localDate) {
//        LocalDate localDate = LocalDate.now();
        int currentMonth = localDate.getMonth().getValue();
        int currentDay = localDate.getDayOfMonth();

        if (currentMonth >= 3 && currentDay >= 1 && currentMonth <= 5 && currentDay <= 31) {
            return SPRING;
        } else if (currentMonth >= 6 && currentDay >= 1 && currentMonth <= 8 && currentDay <= 31) {
            return SUMMER;
        } else if (currentMonth >= 9 && currentDay >= 1 && currentMonth <= 11 && currentDay <= 31) {
            return FALL;
        } else {
            return WINTER;
        }
    }
}
