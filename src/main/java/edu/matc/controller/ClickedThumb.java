package edu.matc.controller;

import edu.matc.persistence.*;
import edu.matc.entity.*;
import org.themoviedb.credits.Cast;
import org.themoviedb.credits.CastItem;
import org.themoviedb.credits.CrewItem;
import org.themoviedb.query.TmdbQueryResults;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (
        name = "ClickedThumb",
        urlPatterns = "/clickedThumb"
)
public class ClickedThumb extends HttpServlet {
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
        String tmdbApiKey = (String)session.getAttribute("tmdb.api.key");
        String tmdbQueryUrl = (String)session.getAttribute("tmdb.query.url");
        String currentUser = (String)session.getAttribute("currentUser");
        String baseUrlTmdb = (String)session.getAttribute("baseUrlTmdb");
        String logoSizeTmdb = (String)session.getAttribute("logoSizeTmdb");
        String backdropSizeTmdb = (String)session.getAttribute("backdropSizeTmdb");
        int thumbId = Integer.parseInt(request.getParameter("id"));

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(thumbId);

        String posterUri = movie.getPosterUri();
        String movieName = movie.getName();
        int userRating = movie.getUserRating();
        request.setAttribute("ratingNumber", Integer.toString(userRating));


        int movieId = movie.getTmdbId();

        // Go get the movie details
        QueryTmdb queryTmdb = new QueryTmdb();
        TmdbQueryResults tmdbQueryResults = queryTmdb.findMovie(tmdbApiKey, tmdbQueryUrl, movieId);

        String movieDescription = tmdbQueryResults.getOverview();
        request.setAttribute("movieDescription", movieDescription);

        posterUri = baseUrlTmdb + backdropSizeTmdb + "/" + posterUri;

        request.setAttribute("posterUri", posterUri);
        request.setAttribute("movieName", movieName);

//TODO Get the movie rating from the api
        request.setAttribute("publicRating", "images/3-stars(15 percent).jpeg");

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

//TODO Get the movie cast from the api

//        Cast cast = new Cast();
        CreditsTmdb creditsTmdb = new CreditsTmdb();
        Cast cast = creditsTmdb.findCredits(tmdbApiKey, tmdbQueryUrl, movieId);

        List<CastItem> movieCast = cast.getCast();
        request.setAttribute("movieCast", movieCast);

        List<CrewItem> movieCrew = cast.getCrew();
        request.setAttribute("movieCrew", movieCrew);





//TODO Get the time watched from the database
        request.setAttribute("lastTimeWatched", "Saturday, January 2 2018");
//TODO Get the season from the database
        request.setAttribute("seasonOfYear", "Winter");
//TODO Get the weather conditions from the database
        request.setAttribute("weatherConditions", "Snow");
//TODO Get the temperature from the database
        request.setAttribute("temperature", "Cold");




        String url = "/show-movie-details.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}
