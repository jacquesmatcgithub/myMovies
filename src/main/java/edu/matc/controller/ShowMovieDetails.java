package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.ViewingHabit;
import edu.matc.persistence.MovieDao;
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

        //TODO Get the movie rating from the api
        request.setAttribute("publicRating", "images/3-stars(15 percent).jpeg");

        int userRating = movie.getUserRating();
        request.setAttribute("ratingNumber", Integer.toString(userRating));

        String ratingImageName = "images/stars-0.jpeg";

        switch (userRating) {
            case 1:
                ratingImageName = "images/stars-1.jpeg";
                break;
            case 2:
                ratingImageName = "images/stars-2.jpeg";
                break;
            case 3:
                ratingImageName = "images/stars-3.jpeg";
                break;
            case 4:
                ratingImageName = "images/stars-4.jpeg";
                break;
            case 5:
                ratingImageName = "images/stars-5.jpeg";
                break;
        }

        request.setAttribute("userRating", ratingImageName);
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

        String weatherConditions = "~";
        int temp = 0;
        String temperature = "~";
        String lastWatched = "~";
        String viewings = "~";

        Set<ViewingHabit> viewingHabits = movie.getViewingHabits();
        List<ViewingHabit> habitList = new ArrayList<>(viewingHabits);

        if (habitList.size() > 0) {
            weatherConditions = habitList.get(0).getWeatherConditions();
            temperature = Integer.toString(habitList.get(0).getTemp());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
            lastWatched = habitList.get(0).getDateWatched().format(formatter);

            viewings = Integer.toString(habitList.size());
        }

        request.setAttribute("weatherConditions", weatherConditions);
        request.setAttribute("temperature", temperature);
        request.setAttribute("lastWatched", lastWatched);
        request.setAttribute("viewings", viewings);

    }


}
