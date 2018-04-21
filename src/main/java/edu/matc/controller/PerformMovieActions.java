package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (
        name = "PerformMovieActions",
        urlPatterns = "/performMovieActions"
)
public class PerformMovieActions extends HttpServlet {

    private static final String WATCHED_MOVIE = "watched";
    private static final String DELETE_MOVIE = "delete";
    private static final String CLEAR_STATS = "clearStats";

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

        String performMethod = request.getParameter("movieDetailAction");

        CrudMovie crudMovie = new CrudMovie();
        try {

            switch (performMethod) {
                case WATCHED_MOVIE :
                    crudMovie.flagMovieWatched(request);
                    break;
                case DELETE_MOVIE :
                    crudMovie.deleteMovieFromCollection(request);
                    break;
                case CLEAR_STATS :
                    crudMovie.clearMovieStats(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Rebuild the 'show movie details' page
        ShowMovieDetails showMovieDetails = new ShowMovieDetails();
        showMovieDetails.show(request, session);

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/show-movie-details.jsp");
        dispatcher.forward(request, response);
    }

}
