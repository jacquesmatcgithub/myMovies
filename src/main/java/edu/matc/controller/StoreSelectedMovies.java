package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.persistence.MovieDao;
import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.search.TmdbSearchResults;
import org.themoviedb.search.TmdbSearchResultsItem;

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
        name = "StoreSelectedMovies",
        urlPatterns = "/storeSelectedMovies"
)
public class StoreSelectedMovies extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");

        MovieDao movieDao = new MovieDao();

        List<Movie> movies = movieDao.getByPropertyEqual("loginId", currentUser);

        for (Movie movie : movies) {
            if (movie.getState().equals("SC")) {
                movie.setState("IC");
                movieDao.saveOrUpdate(movie);
            }
        }

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/signed-in-collector.jsp");
        dispatcher.forward(request, response);
    }
}
