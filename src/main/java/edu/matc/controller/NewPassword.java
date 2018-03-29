package edu.matc.controller;

import edu.matc.persistence.*;
import edu.matc.entity.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (
        name = "newpassword",
        urlPatterns = "/newPassword"
)
public class NewPassword extends HttpServlet {

    private static final String ADMIN = "admin";
    private static final String COLLECTOR = "collector";

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
        String userLevel = (String)session.getAttribute("userLevel");

        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");

        String url;
        if (userLevel.equals(ADMIN)) {
            url = "/signed-in-admin.jsp";
        } else if (userLevel.equals(COLLECTOR)) {
            url = "/signed-in-collector.jsp";
        } else {
            url = "/login-failed.jsp";
        }

        request.setAttribute("passwordMessage", "Success!");

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}
