package edu.matc.controller;

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

/**
 * The PrepareAdminPage class instantiates an AdminPage object and then invokes the
 * signed-in-admin.jsp
 * */
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

        request.removeAttribute("signInMessage");

        logger.info("Setting up Admin Page");

        AdminPage adminPage = new AdminPage();
        adminPage.load(request);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("adminPage", adminPage);

        HttpSession session = request.getSession();

//      Here are two ways to get the user id after authentication
//      String loginId = request.getUserPrincipal().getName();  This also works
//      loginId = request.getRemoteUser();

        session.setAttribute("currentUser", request.getRemoteUser());
        session.setAttribute("userLevel", "admin");


        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/signed-in-admin.jsp");
        dispatcher.forward(request, response);
    }
}
