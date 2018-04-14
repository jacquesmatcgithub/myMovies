package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.query.TmdbQueryResults;
import org.themoviedb.search.TmdbSearchResults;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (
        name = "addMovie",
        urlPatterns = "/addNewMovie"
)
public class AddNewMovie extends HttpServlet {
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

        String movieName = request.getParameter("movieName");
        String tmdbSearchUrl = (String)session.getAttribute("tmdb.search.url");
        String tmdbApiKey = (String)session.getAttribute("tmdb.api.key");

/*
        QueryTmdb queryTmdb = new QueryTmdb();
        TmdbQueryResults tmdbQueryResults = queryTmdb.findMovie(tmdbApiKey, tmdbSearchUrl, movieName);

        tmdbQueryResults.getOriginalTitle();


        SearchTmdb searchTmdb = new SearchTmdb();
        TmdbSearchResults tmdbSearchResults = searchTmdb.findMovie(tmdbApiKey, tmdbSearchUrl, movieName);

        switch (tmdbSearchResults.getTotalResults()) {
            case 0:
                session.setAttribute("addNewMovieMessage", "Nothing found");
                break;

            case 1:
                foundOneMovie(tmdbSearchResults);
                break;

            default:
                foundMultipleMovies(tmdbSearchResults);
                break;
        }
*/
        String url = "/signed-in-collector.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }



    /**
     * If one movie was found, then display the single movie found page.
     *
     * @param tmdbSearchResults
     */
    private void foundOneMovie(TmdbSearchResults tmdbSearchResults) {

    }


    /**
     * If multiple movies were found, then display the multi-movie found page
     *
     * @param tmdbSearchResults
     */
    private void foundMultipleMovies(TmdbSearchResults tmdbSearchResults) {

    }
}
