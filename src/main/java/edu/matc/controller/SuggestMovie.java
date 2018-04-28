package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.persistence.MovieDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
//            url = "/prepareCollectorPage";
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
        }
    }
}



