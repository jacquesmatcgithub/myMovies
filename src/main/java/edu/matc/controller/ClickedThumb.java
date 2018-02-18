package edu.matc.controller;

import edu.matc.persistence.*;
import edu.matc.entity.*;

import java.io.*;
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
        String currentUser = (String)session.getAttribute("currentUser");
        String baseUrlTmdb = (String)session.getAttribute("baseUrlTmdb");
        String logoSizeTmdb = (String)session.getAttribute("logoSizeTmdb");
        String backdropSizeTmdb = (String)session.getAttribute("backdropSizeTmdb");

        int thumbId = Integer.parseInt(request.getParameter("id"));


        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(thumbId);

        String posterUri = movie.getPosterUri();
        String movieName = movie.getName();

        String movieDescription = "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ";

        posterUri = baseUrlTmdb + backdropSizeTmdb + "/" + posterUri;

        request.setAttribute("posterUri", posterUri);
        request.setAttribute("movieName", movieName);
        request.setAttribute("movieDescription", movieDescription);
        request.setAttribute("publicRating", "images/3-stars(15 percent).jpeg");
        request.setAttribute("yourRating", "images/5-stars(15 percent).jpeg");
        request.setAttribute("movieCast", movieDescription);
        request.setAttribute("lastTimeWatched", "Saturday, January 2 2018");
        request.setAttribute("seasonOfYear", "Winter");
        request.setAttribute("weatherConditions", "Snow");
        request.setAttribute("temperature", "Cold");




        String url = "/jsp/show-movie-details.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}
