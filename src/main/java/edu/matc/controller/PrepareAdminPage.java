package edu.matc.controller;

import edu.matc.entity.MetadataTmdb;
import edu.matc.entity.User;
import edu.matc.persistence.MetadataTmdbDao;
import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The ValidateSigninServlet validates the user and password. It also then routes the
 * user to either the admin page or the movie grid page depending on whether the user
 * is an admin user or a regular user.
 */
@WebServlet (
        name = "PrepareAdminPage",
        urlPatterns = "/prepareAdminPage"
)
public class PrepareAdminPage extends HttpServlet {

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

//        String loginId = request.getParameter("loginId").trim();

        request.removeAttribute("signInMessage");

        logger.info("Setting up Admin Page");

        AdminPage adminPage = new AdminPage();
        adminPage.load(request);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("adminPage", adminPage);

        HttpSession session = request.getSession();
        //TODO Figure out how to get the user id that was authenticated so we can set the "currentUser" session attribute
        session.setAttribute("currentUser", "jfourieadmin");

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/signed-in-admin.jsp");
        dispatcher.forward(request, response);
    }
}
