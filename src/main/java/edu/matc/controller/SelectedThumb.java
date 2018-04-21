package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.persistence.MovieDao;
import org.themoviedb.credits.Cast;
import org.themoviedb.credits.CastItem;
import org.themoviedb.credits.CrewItem;
import org.themoviedb.query.TmdbQueryResults;

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
        name = "SelectedThumb",
        urlPatterns = "/selectedThumb"
)
public class SelectedThumb extends HttpServlet {
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
        int thumbId = Integer.parseInt(request.getParameter("id"));

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(thumbId);

        if (movie.getMovieState().equals("SR")) {
            movie.setMovieState("SC");
        } else {
            movie.setMovieState("SR");
        }

        movieDao.saveOrUpdate(movie);


        String url = "/signed-in-collector-search-results.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}
