package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.entity.ViewingHabit;
import edu.matc.persistence.MovieDao;
import org.hibernate.Session;
import org.themoviedb.credits.Cast;
import org.themoviedb.credits.CastItem;
import org.themoviedb.credits.CrewItem;
import org.themoviedb.query.TmdbQueryResults;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type Show movie details.
 */
public class ShowMovieDetails {

    /**
     * Instantiates a new Show movie details.
     */
    public ShowMovieDetails() {

    }


    /**
     * Show.
     *
     * @param request the request
     * @param session the session
     */
    public void show(HttpServletRequest request,
                            HttpSession session) {

        String tmdbApiKey = (String)session.getAttribute("tmdb.api.key");
        String tmdbQueryUrl = (String)session.getAttribute("tmdb.query.url");

        int thumbId = 0;
        String thumbIdString = request.getParameter("thumbId");

        if (thumbIdString != null) {
            thumbId = Integer.parseInt(thumbIdString);
            // This attribute is used by the CrudMovie class to know which
            // specific movie was selected from the movie grid
            session.setAttribute("movieId", thumbId);
        } else {
            thumbId = (Integer) session.getAttribute("movieId");
        }


        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(thumbId);

        int movieId = movie.getTmdbId();

        showMoviePoster(request, session, movie);
        showMovieDescription(request, tmdbApiKey, tmdbQueryUrl, movieId);
        showMovieRatings(request, movie);
        showCastAndCrew(request, tmdbApiKey, tmdbQueryUrl, movieId);
        showViewingHabit(request, movie);
    }

    /**
     * Show movie poster.
     *
     * @param request the request
     * @param session the session
     * @param movie   the movie
     */
    private void showMoviePoster(HttpServletRequest request,
                                HttpSession session,
                                Movie movie) {
        String baseUrlTmdb = (String)session.getAttribute("baseUrlTmdb");
        String backdropSizeTmdb = (String)session.getAttribute("backdropSizeTmdb");


        String posterUri = movie.getPosterUri();
        String movieName = movie.getName();

        posterUri = baseUrlTmdb + backdropSizeTmdb + "/" + posterUri;
        request.setAttribute("posterUri", posterUri);
        request.setAttribute("movieName", movieName);

    }

    /**
     * Show movie description.
     *
     * @param request      the request
     * @param tmdbApiKey   the tmdb api key
     * @param tmdbQueryUrl the tmdb query url
     * @param movieId      the movie id
     */
    private void showMovieDescription(HttpServletRequest request,
                                      String tmdbApiKey,
                                      String tmdbQueryUrl,
                                      int movieId) {

        QueryTmdb queryTmdb = new QueryTmdb();
        TmdbQueryResults tmdbQueryResults = queryTmdb.findMovie(tmdbApiKey, tmdbQueryUrl, movieId);

        String movieDescription = tmdbQueryResults.getOverview();
        request.setAttribute("movieDescription", movieDescription);
    }

    /**
     * Show movie ratings.
     *
     * @param request the request
     * @param movie   the movie
     */
    private void showMovieRatings(HttpServletRequest request, Movie movie) {

        int count = 0;

        //TODO Get the movie rating from the api
        for (count = 1; count < 6; count++) {
            request.setAttribute("publicRating" + count, "images/star-no-80.jpeg");
        }

        int userRating = movie.getUserRating();

        for (count = 1; count < 6; count++) {
            request.setAttribute("ratingNumber" + count, count);
            if (count <= userRating) {
                request.setAttribute("userRating" + count, "images/star-yes-80.jpeg");
            } else {
                request.setAttribute("userRating" + count, "images/star-no-80.jpeg");
            }
        }
    }


    /**
     * Show cast and crew.
     *
     * @param request      the request
     * @param tmdbApiKey   the tmdb api key
     * @param tmdbQueryUrl the tmdb query url
     * @param movieId      the movie id
     */
    private void showCastAndCrew(HttpServletRequest request,
                                 String tmdbApiKey,
                                 String tmdbQueryUrl,
                                 int movieId) {

        CreditsTmdb creditsTmdb = new CreditsTmdb();
        Cast cast = creditsTmdb.findCredits(tmdbApiKey, tmdbQueryUrl, movieId);

        List<CastItem> movieCast = cast.getCast();
        request.setAttribute("movieCast", movieCast);

        List<CrewItem> movieCrew = cast.getCrew();
        request.setAttribute("movieCrew", movieCrew);

    }


    /**
     * Show viewing habit.
     *
     * @param request the request
     * @param movie   the movie
     */
    private void showViewingHabit(HttpServletRequest request,
                                  Movie movie) {

        HttpSession session = request.getSession();

        request.removeAttribute("forecastUrl");
        request.removeAttribute("weatherConditions");
        request.removeAttribute("temperature");
        request.removeAttribute("lastWatched");
        request.removeAttribute("viewings");
        request.removeAttribute("weatherIcon");


        String weatherConditions = "~";
        int temp = 0;
        String temperature = "~";
        String lastWatched = "~";
        String viewings = "~";
        String wundergroundIconPath = (String)session.getAttribute("wunderground.icon.url");
        String wundergroundForecastUrl = (String)session.getAttribute("wunderground.forecast.url");
        String weatherIconName = "";
        String weatherIconUtl = "";


        Set<ViewingHabit> viewingHabits = movie.getViewingHabits();
        List<ViewingHabit> habitList = new ArrayList<>(viewingHabits);

        if (habitList.size() > 0) {
            weatherConditions = habitList.get(0).getWeatherConditions();
            temperature = Integer.toString(habitList.get(0).getTemp()) + "F";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
            lastWatched = habitList.get(0).getDateWatched().format(formatter);

            viewings = Integer.toString(habitList.size());

            weatherIconName = habitList.get(0).geticonName();
            weatherIconUtl = habitList.get(0).getIconUrl();


//            wundergroundIconPath = wundergroundIconPath.replace("{iconName}", weatherIconName);
            wundergroundIconPath = weatherIconUtl;
            request.setAttribute("weatherIcon", wundergroundIconPath);


            User user = movie.getUser();
            String city = user.getCity();
            String state = user.getState();

            wundergroundForecastUrl = wundergroundForecastUrl.replace("{city}", city);
            wundergroundForecastUrl = wundergroundForecastUrl.replace("{state}", state);

            request.setAttribute("forecastUrl", wundergroundForecastUrl);
        }

        request.setAttribute("weatherConditions", weatherConditions);
        request.setAttribute("temperature", temperature);
        request.setAttribute("lastWatched", lastWatched);
        request.setAttribute("viewings", viewings);
    }


}
