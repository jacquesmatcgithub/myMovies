package edu.matc.controller;

import edu.matc.entity.MetadataTmdb;
import edu.matc.persistence.MetadataTmdbDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The ValidateSigninServlet validates the user and password. It also then routes the
 * user to either the admin page or the movie grid page depending on whether the user
 * is an admin user or a regular user.
 */
@WebServlet (
        name = "PrepareUserPage",
        urlPatterns = "/prepareUserPage"
)
public class PrepareUserPage extends HttpServlet {

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

        logger.info("Setting up User Page");


        HttpSession session = request.getSession();


        /**
         * Here are two ways to get the user id after authentication
         */
//        String loginId = request.getUserPrincipal().getName();  This also works
//        loginId = request.getRemoteUser();

        session.setAttribute("currentUser", request.getRemoteUser());


        MetadataTmdbDao metadataTmdbDao = new MetadataTmdbDao();
        MetadataTmdb metadataTmdb = metadataTmdbDao.getById(1);
        session.setAttribute("baseUrlTmdb", metadataTmdb.getBaseUrl());
        session.setAttribute("logoSizeTmdb", metadataTmdb.getLogoSize());
        session.setAttribute("backdropSizeTmdb", metadataTmdb.getBackdropSize());

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/signed-in-user.jsp");
        dispatcher.forward(request, response);
    }
}
