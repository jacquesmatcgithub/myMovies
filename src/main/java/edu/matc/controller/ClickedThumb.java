package edu.matc.controller;

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
        ShowMovieDetails showMovieDetails = new ShowMovieDetails();
        showMovieDetails.show(request, session);

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/show-movie-details.jsp");
        dispatcher.forward(request, response);
    }

}
