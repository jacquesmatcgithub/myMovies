package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Generate movie grid.
 *
 *
 *
 * This class will generate a movie grid based on what a search of the tmdb webservice
 * returned.
 * When the user adds a movie, a call is made to tmdb.  If more than one movie is returned,
 * they are stored in the user's movie table with a flag of some sorts to show these are
 * the results of a search.  This page will only display movies with that flag set. The
 * GenerateMovieGrid class on the other hand will only display movies where that flag is not
 * set.
 *
 *
 *
 *
 *
 *
 */
//TODO Structure this class better
public class GenerateMovieSelectGrid extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public static void generateSelectGrid(JspWriter out, HttpServletRequest request)
            throws IOException {
        HttpSession session = request.getSession();
        String currentUser = (String)session.getAttribute("currentUser");

        String baseUrlTmdb = (String)session.getAttribute("baseUrlTmdb");
        String logoSizeTmdb = (String)session.getAttribute("logoSizeTmdb");

        UserDao userDao = new UserDao();

        List<User> users = userDao.getByPropertyEqual("loginId" , currentUser);

        Set<Movie> movies = users.get(0).getMovies();
        List<Movie> movieList = movies.stream().collect(Collectors.toList());

        if (movieList.size() == 0) {
            return;
        }

        String holdSortLocation = refinedHoldSortLocation(movieList.get(0).getSortKey());

        out.print("<table>");
        out.print(holdSortLocation);

        int colCount = 1;

        for (Movie thisMovie : movieList) {
            // If the movie is not flagged as temporary then it will not appear
            // on this movie grid.
            if (!thisMovie.isTemp()) {
                continue;
            }

            String sortLocation = refinedHoldSortLocation(thisMovie.getSortKey());

            if (!sortLocation.equals(holdSortLocation)) {
                colCount = 1;
                holdSortLocation = sortLocation;
                out.print("</table>");
                out.print("<br/>" + holdSortLocation);
                out.print("<table>");
            }

            if (colCount == 1) {
                out.print("<tr>");
            }

            out.print("<td><a href=\"selectedThumb?id=" + thisMovie.getId() + "\"" +
                    "><img src=\"" + baseUrlTmdb + logoSizeTmdb + "/" +
                    thisMovie.getPosterUri() + "\"" +
                    " class=\"movieThumbBorder\"" + " title=\"" + thisMovie.getName() + "\"></a></td>");
//                  " class=\"post-img\"" + " title=\"" + thisMovie.getName() + "\"></a></td>");

            colCount += 1;

            if (colCount == 9) {
                out.print("</tr>");
                colCount = 1;
            }
        }
        if (colCount < 9) {
            out.print("</tr>");
        }
        out.print("</table>");
    }

    /**
     * The refinedHoldSortLocation method will return an all-numeric hold location string if the holdLocation
     * string passed into it starts with a numeric. If it doesn't, then only the first character of the
     * holdLocation will be returned.
     * @param holdSortLocation
     * @return
     */
    private static String refinedHoldSortLocation(String holdSortLocation) {

        // The first byte is not numeric
        if (!holdSortLocation.substring(0,1).matches("[0-9]+")) {
            return holdSortLocation.substring(0,1);
        } else {
            return "0-9";
        }
    }
}


