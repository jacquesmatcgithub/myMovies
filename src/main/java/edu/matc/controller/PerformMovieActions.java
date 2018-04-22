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

        String returnUrl = "/show-movie-details.jsp";

        HttpSession session = request.getSession();

        String performMethod = request.getParameter("movieDetailAction");

        CrudMovie crudMovie = new CrudMovie();
        try {

            switch (performMethod) {
                case WATCHED_MOVIE :
                    crudMovie.flagMovieWatched(request);
                    rebuildMovieDetailPage(request, session);
                    returnUrl = "/show-movie-details.jsp";
                    break;
                case DELETE_MOVIE :
                    crudMovie.deleteMovieFromCollection(request);
                    returnUrl = "/signed-in-collector.jsp";
                    break;
                case CLEAR_STATS :
                    crudMovie.clearMovieStats(request);
                    rebuildMovieDetailPage(request, session);
                    returnUrl = "/show-movie-details.jsp";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Rebuild the 'show movie details' page

//        ShowMovieDetails showMovieDetails = new ShowMovieDetails();
//        showMovieDetails.show(request, session);

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(returnUrl);
        dispatcher.forward(request, response);
    }

    /**
     * The rebuildMovieDetailPage method repopulates the movie detail page. This is
     * only done for the WATCHED_MOVIE and CLEAR_STATS menu selectios. The reason
     * for this is, when the user selects the DELETE_MOVIE option the movie details
     * page will not be displayed again. Instead, the user will be routed back to the
     * movie grid.
     *
     * @param request
     * @param session
     */
    private void rebuildMovieDetailPage(HttpServletRequest request,
                                        HttpSession session) {
        ShowMovieDetails showMovieDetails = new ShowMovieDetails();
        showMovieDetails.show(request, session);
    }

}
