package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.persistence.MovieDao;
import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.themoviedb.query.TmdbQueryResults;
import org.themoviedb.search.TmdbSearchResults;
import org.themoviedb.search.TmdbSearchResultsItem;

import java.io.*;
import java.util.List;

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
        String url = "";

        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");

        String movieName = request.getParameter("movieName");
        String tmdbSearchUrl = (String)session.getAttribute("tmdb.search.url");
        String tmdbApiKey = (String)session.getAttribute("tmdb.api.key");

        SearchTmdb searchTmdb = new SearchTmdb();
        TmdbSearchResults tmdbSearchResults = searchTmdb.findMovie(tmdbApiKey, tmdbSearchUrl, movieName);

        if (tmdbSearchResults.getTotalResults() == 0) {
            session.setAttribute("addNewMovieMessage", "Nothing found");
            url = "/signed-in-collector.jsp";
        } else {
            loadMovieTable(currentUser, movieName, tmdbSearchResults);

            if (tmdbSearchResults.getTotalResults() == 1)
                url = "/signed-in-collector-search-results.jsp";
            else
                url = "/signed-in-collector-search-results.jsp";
        }

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    private void loadMovieTable(String currentUser, String movieName, TmdbSearchResults tmdbSearchResults) {

        int moviesLoaded = 0;

        UserDao userDao = new UserDao();
        List<User> users = userDao.getByPropertyEqual("loginId", currentUser);
        User user = users.get(0);

        MovieDao movieDao = new MovieDao();

        List<TmdbSearchResultsItem> tmdbSearchResultsItems = tmdbSearchResults.getResults();

        for (TmdbSearchResultsItem item : tmdbSearchResultsItems) {
            logger.debug("id:" + item.getId() + "   Title:" + item.getTitle());

            String movieTitle = generateMovieSortKey(item.getTitle());

            Movie movie = new Movie(
                    item.getTitle(),
                    item.getPosterPath(),
                    "test",
                    "test",
                    "test",
                    0,
                    movieTitle,
                    currentUser,
                    item.getId(),
                    "SR",
                    user);

            movieDao.saveOrUpdate(movie);

        }
    }



    private String generateMovieSortKey(String movieTitle) {
        return movieTitle.toLowerCase().replaceAll("\\s+", "");
    }

}
