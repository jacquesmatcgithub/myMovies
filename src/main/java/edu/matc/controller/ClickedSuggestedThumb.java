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
        name = "ClickedSuggestedThumb",
        urlPatterns = "/clickedSuggestedThumb"
)
public class ClickedSuggestedThumb extends HttpServlet {
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
        ShowMovieDetails showMovieDetails = new ShowMovieDetails();
        showMovieDetails.show(request, session);

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/show-suggested-movie-details.jsp");
        dispatcher.forward(request, response);
    }

}
