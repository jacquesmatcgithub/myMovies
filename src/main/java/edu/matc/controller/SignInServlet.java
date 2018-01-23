package edu.matc.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (
        name = "SignInServlet",
        urlPatterns = "/signIn"
)
public class SignInServlet extends HttpServlet {
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

        String url = "/jsp/sign-in.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }



}
