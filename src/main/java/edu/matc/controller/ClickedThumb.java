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


        String thumbId = request.getParameter("id");

        // set all the parameters the display page will need here.
        // things like the movie poster, description, and all that

        String url = "/jsp/show-movie-details.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}
