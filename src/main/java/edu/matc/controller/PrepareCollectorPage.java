package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.persistence.MovieDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The ValidateSigninServlet validates the user and password. It also then routes the
 * user to either the admin page or the movie grid page depending on whether the user
 * is an admin user or a regular user.
 */
@WebServlet (
        name = "PrepareCollectorPage",
        urlPatterns = "/prepareCollectorPage"
)
public class PrepareCollectorPage extends HttpServlet {

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

        request.removeAttribute("signInMessage");

        logger.info("Setting up Collector TmdbSearchPage");

        HttpSession session = request.getSession();

        /**
         * Here are two ways to get the user id after authentication
         */
//        String loginId = request.getUserPrincipal().getName();  This also works
//        loginId = request.getRemoteUser();

        session.setAttribute("currentUser", request.getRemoteUser());
        session.setAttribute("userLevel", "collector");

        // Load myMovies.properties, call the tmdb api and set session attributes for all
        AppConfig appConfig = new AppConfig(request);

        cleanupUserMovies(request.getRemoteUser());

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/signed-in-collector.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * The cleanupUserMovies method deleted all movies from the user's movie table
     * where the state of the move is not IC (in collection).
     * The reason for this is, there may be temporary movies in the user's table
     * from doing a movie search in a previous session.
     * @param currentUser
     */
    private void cleanupUserMovies(String currentUser) {

        CleanupUserMovieCatalog cleanup = new CleanupUserMovieCatalog();
        cleanup.deleteNonCatalogMovies(currentUser);
    }
}
