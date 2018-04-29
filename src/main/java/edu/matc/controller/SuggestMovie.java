package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.entity.ViewingHabit;
import edu.matc.persistence.MovieDao;
import edu.matc.persistence.ViewingHabitDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet (
        name = "SuggestMovie",
        urlPatterns = "/suggestMovie"
)
public class SuggestMovie extends HttpServlet {
    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpRequest
     * @param response the HttpResponse
     * @throws ServletException if there is a general
     *                          servlet exception
     * @throws IOException      if there is a general
     *                          I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");

        CleanupUserMovieCatalog cleanupUserMovieCatalog = new CleanupUserMovieCatalog();
        cleanupUserMovieCatalog.deleteNonCatalogMovies(currentUser);

        String url = "";

        Suggest suggest = new Suggest();
        List<Movie> suggestList = suggest.multipleMovies(request);

        if (!suggestList.isEmpty()) {
            addSuggestedMovies(suggestList);
            url = "/show-suggested-movies.jsp";
        } else {
            url = "/signed-in-collector.jsp";
        }


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     * The addSuggestedMovies method will add the suggested movies to the collector's
     * collection with a movie_state of SU.
     *
     * @param movies
     */
    private void addSuggestedMovies(List<Movie> movies) {
        MovieDao movieDao = new MovieDao();

        for (Movie thisMovie : movies) {
            Movie insertMovie = new Movie(
                    thisMovie.getName(),
                    thisMovie.getPosterUri(),
                    thisMovie.getThumbUri(),
                    thisMovie.getDescUri(),
                    thisMovie.getRatingUri(),
                    thisMovie.getUserRating(),
                    thisMovie.getSortKey(),
                    thisMovie.getLoginId(),
                    thisMovie.getTmdbId(),
                    "SU",
                    thisMovie.getUser());

            movieDao.saveOrUpdate(insertMovie);

            addSuggestedMovieViewingHabit(thisMovie.getUser(),
                                          thisMovie,
                                          insertMovie);
        }
    }

    private void addSuggestedMovieViewingHabit(User thisUser,
                                               Movie thisMovie,
                                               Movie insertMovie) {

        ViewingHabitDao viewingHabitDao = new ViewingHabitDao();
        Set<ViewingHabit> viewingHabits = thisMovie.getViewingHabits();
        List<ViewingHabit> habitList = new ArrayList<>(viewingHabits);

        if (!habitList.isEmpty()) {
            int movieId = habitList.get(0).getMovieId();
            LocalDate dateWatched= habitList.get(0).getDateWatched();
            int temp = habitList.get(0).getTemp();
            String conditions = habitList.get(0).getWeatherConditions();
            String iconName = habitList.get(0).geticonName();
            String iconUrl = habitList.get(0).getIconUrl();

            ViewingHabit viewingHabit = new ViewingHabit(movieId,
                    dateWatched,
                    temp,
                    conditions,
                    iconName,
                    iconUrl,
                    thisUser,
                    insertMovie);

            viewingHabitDao.saveOrUpdate(viewingHabit);
        }
    }

}



