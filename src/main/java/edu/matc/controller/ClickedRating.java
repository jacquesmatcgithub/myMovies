package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.persistence.MovieDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (
        name = "ClickedRating",
        urlPatterns = "/clickedRating"
)
public class ClickedRating extends HttpServlet {
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
        int movieId = (Integer) session.getAttribute("movieId");

        int ratingNumber = Integer.parseInt(request.getParameter("ratingNumber"));

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(movieId);
        movie.setUserRating(ratingNumber);
        movieDao.saveOrUpdate(movie);

        // Rebuild the 'show movie details' page
        ShowMovieDetails showMovieDetails = new ShowMovieDetails();
        showMovieDetails.show(request, session);

        String url = "/show-movie-details.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
