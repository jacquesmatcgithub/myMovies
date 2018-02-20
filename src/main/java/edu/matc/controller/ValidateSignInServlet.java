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

/**
 * The ValidateSigninServlet validates the user and password. It also then routes the
 * user to either the admin page or the movie grid page depending on whether the user
 * is an admin user or a regular user.
 */
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

        String loginId = request.getParameter("loginId").trim();
        String password = request.getParameter("password").trim();

        List<User> users = userDao.getByPropertyEqual("loginId", loginId);
        
        if (users.size() == 0 || !users.get(0).getPassword().equals(password)) {
            url = "/jsp/sign-in.jsp";
            request.setAttribute("signInMessage", "Invalid Sign In");
        } else if (users.get(0).getAdmin()) {
            url = setupAdminUser(request, response);
        } else {
            url = setupNormalUser(request, response);
        }

        HttpSession session = request.getSession();
        session.setAttribute("currentUser", loginId);

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     *  If the user is an admin user the setupAdminUser method will route processing to
     *  the admin page.
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
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


    /**
     *  If the user is a regular user the setupNormalUser method will route processing to
     *  the movie grid page.
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    private String setupNormalUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.removeAttribute("signInMessage");

        logger.info("Setting up Admin Page");

        MetadataTmdbDao metadataTmdbDao = new MetadataTmdbDao();

        MetadataTmdb metadataTmdb = metadataTmdbDao.getById(1);

        HttpSession session = request.getSession();
        session.setAttribute("baseUrlTmdb", metadataTmdb.getBaseUrl());
        session.setAttribute("logoSizeTmdb", metadataTmdb.getLogoSize());
        session.setAttribute("backdropSizeTmdb", metadataTmdb.getBackdropSize());

        return "/jsp/signed-in-user.jsp";
    }
}
