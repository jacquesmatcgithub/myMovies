package edu.matc.controller;

import com.wunderground.api.CurrentObservation;
import com.wunderground.api.WeatherResponse;
import com.wunderground.api.Wunderground;
import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.entity.ViewingHabit;
import edu.matc.persistence.MovieDao;
import edu.matc.persistence.UserDao;
import edu.matc.persistence.ViewingHabitDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type Crud movie.
 */
public class CrudMovie {

    /**
     * Instantiates a new Crud movie.
     */
    public CrudMovie() {
    }

    /**
     * Flag movie watched.
     *
     * @param request the request
     */
    public void flagMovieWatched(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");
        int movieId = (Integer)session.getAttribute("movieId");

        // Get the current weather conditions
        Wunderground wunderground = new Wunderground();
        WeatherResponse weatherResponse = wunderground.getCurrentConditions(request);
        int localTemp = (int)weatherResponse.getCurrentObservation().getTempF();
        String weatherConditions = weatherResponse.getCurrentObservation().getWeather();
        String iconName = weatherResponse.getCurrentObservation().getIcon();
        String iconUrl = weatherResponse.getCurrentObservation().getIconUrl();

        UserDao userDao = new UserDao();
        List<User> users = userDao.getByPropertyEqual("loginId", currentUser);

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(movieId);

        ViewingHabitDao viewingHabitDao = new ViewingHabitDao();
        ViewingHabit viewingHabit = new ViewingHabit(movieId,
                LocalDate.now(),
                localTemp,
                weatherConditions,
                iconName,
                iconUrl,
                users.get(0),
                movie);

        viewingHabitDao.saveOrUpdate(viewingHabit);

    }

    /**
     * Delete movie from collection.
     *
     * @param request the request
     */
    public void deleteMovieFromCollection(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");
        int movieId = (Integer)session.getAttribute("movieId");

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(movieId);
        movieDao.delete(movie);

    }

    /**
     * Clear movie stats.
     *
     * @param request the request
     */
    public void clearMovieStats(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");
        int movieId = (Integer)session.getAttribute("movieId");

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(movieId);
        Set<ViewingHabit> viewingHabits = movie.getViewingHabits();
        List<ViewingHabit> habitList = new ArrayList<>(viewingHabits);

        ViewingHabitDao viewingHabitDao = new ViewingHabitDao();


        for (ViewingHabit habit : habitList) {
            viewingHabitDao.delete(habit);
        }
    }

}
