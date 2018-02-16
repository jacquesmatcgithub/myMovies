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
        name = "ValidateSignInServlet",
        urlPatterns = "/validateSignIn"
)
public class ValidateSignInServlet extends HttpServlet {

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
        session.removeAttribute("loginId");

        String userId = request.getParameter("loginId").trim();
        String password = request.getParameter("password").trim();

        List<User> users = userDao.getByPropertyEqual("loginId", userId);


        if (users.size() == 0 || !users.get(0).getPassword().equals(password)) {
            url = "/jsp/sign-in.jsp";
            request.setAttribute("signInMessage", "Invalid Sign In");
        } else if (users.get(0).getAdmin()) {
            url = setupAdminUser(request, response);
        } else {
            url = setupNormalUser(request, response);
        }

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private String  setupAdminUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.removeAttribute("signInMessage");

        logger.info("Setting up Admin Page");

        AdminPage adminPage = new AdminPage();
        adminPage.load(request);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("adminPage", adminPage);

        return "/jsp/signed-in-admin.jsp";
    }


    private String setupNormalUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        return "/jsp/signed-in-user.jsp";

    }
}
