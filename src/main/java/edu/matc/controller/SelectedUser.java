package edu.matc.controller;

import edu.matc.persistence.*;
import edu.matc.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (
        name = "SelectedUser",
        urlPatterns = "/selectedUser"
)
public class SelectedUser extends HttpServlet {

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

        UserDao userDao = new UserDao();
        String url;

        HttpSession session = request.getSession();
        session.removeAttribute("userId");

        String userIdSelected = request.getParameter("listOfUsers").trim();

        List<User> users = userDao.getByPropertyEqual("userId", userIdSelected);

        request.setAttribute("detailsUserId", users.get(0).getUserId());
        request.setAttribute("detailsFirstName", users.get(0).getFirstName());
        request.setAttribute("detailsLastName", users.get(0).getLastName());
//TODO Must still populate the catalog name
        request.setAttribute("detailsCatalogName", "catalog table not defined yet");
        request.setAttribute("detailsDateActive", users.get(0).getDateActive());

        if (users.get(0).getActive()) {
            request.setAttribute("detailsActive", "Y");
        } else {
            request.setAttribute("detailsActive", "N");
        }


        request.setAttribute("users", userDao.getAllUsers());

        url = "/jsp/signed-in-admin.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
