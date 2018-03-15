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
        String currentUser = (String)session.getAttribute("currentUser");

        int ratingNumber = Integer.parseInt(request.getParameter("ratingNumber")) + 1;

        if (ratingNumber > 5) {
            ratingNumber = 1;
        }

        String ratingImageName = "images/stars-0.jpeg";

        switch (ratingNumber) {
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



        String url = "/show-movie-details.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}
