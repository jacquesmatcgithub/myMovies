package edu.matc.controller;

import edu.matc.persistence.*;
import edu.matc.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//TODO Add better javadoc

/**
 * The type Crud movie stats.
 */
@WebServlet (
        name = "CrudMovieStatsServlet",
        urlPatterns = "/crudMovieStats"
)
public class CrudMovieStats extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The BUTTON_PRESSED constant is the name of every button on the Admin TmdbSearchPage.
     */
    private static final String BUTTON_PRESSED = "adminPageButton";

    private static final String BUTTON_RESET_STATS = "Reset";
    private static final String BUTTON_RESET_ALL_STATS = "Reset All";

    private static final String MSG_USER_ADDED_UPDATED_SUCCESSFULLY = "Added/updated successfully";
    private static final String MSG_USER_DELETED_SUCCESSFULLY = "User deleted successfully";
    private static final String MSG_ENTER_FIELD = "Please enter field";


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
        String url = "signed-in-admin.jsp";
        String userDetailsMessage = "";

        HttpSession session = request.getSession();

        // Find which button was pressed on the Admin TmdbSearchPage
        String buttonPressed = request.getParameter(BUTTON_PRESSED);


        // Capture all the user details fields for processing and redisplay
        String formUserId = request.getParameter("userId");
        String formFirstName = request.getParameter("firstName");
        String formLastName = request.getParameter("lastName");
        String formCatalogName = request.getParameter("catalogName");

        LocalDate formDateActive = LocalDate.parse("2018-01-01");
        String formDateActiveString = request.getParameter("dateActive");
        if (formDateActiveString != null) {
            formDateActive = LocalDate.parse(formDateActiveString);
        }

        boolean formAdminUser = false;

        if (request.getParameter("adminUser") != null) {
            formAdminUser = true;
        }

        boolean formActiveUser = false;

        if (request.getParameter("activeUser") != null) {
            formActiveUser = true;
        }


        // Act on which button was pressed
        switch (buttonPressed) {
            case BUTTON_RESET_STATS:
                userDetailsMessage = resetStats(request, userDao);
                break;
            case BUTTON_RESET_ALL_STATS:
                userDetailsMessage = resetAllStats(request, userDao);
                break;
        }

        request.setAttribute("userDetailsMessage", userDetailsMessage);

        populateAdminPage(request, userDao, formUserId, formFirstName, formLastName, formCatalogName,
                formDateActive, formAdminUser, formActiveUser);


        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     *
     * @param request
     * @param userDao
     * @return
     */
    private String resetStats(HttpServletRequest request, UserDao userDao) {
        return "";
    }


    /**
     *
     * @param request
     * @param userDao
     * @return
     */
    private String resetAllStats(HttpServletRequest request, UserDao userDao) {
        return "";
    }


    /**
     *
     * @param request
     * @param userDao
     * @param formUserId
     * @param formFirstName
     * @param formLastName
     * @param formCatalogName
     * @param formDateActive
     * @param formAdminUser
     * @param formActiveUser
     */
    private void populateAdminPage(HttpServletRequest request, UserDao userDao,  String formUserId, String formFirstName,
                                   String formLastName, String formCatalogName, LocalDate formDateActive, boolean formAdminUser,
                                   boolean formActiveUser) {

        request.setAttribute("users", userDao.getAllUsers());

        request.setAttribute("detailsUserId", formUserId);
        request.setAttribute("detailsFirstName", formFirstName);
        request.setAttribute("detailsLastName", formLastName);
        request.setAttribute("detailsDateActive", formDateActive);

        if (formActiveUser) {
            request.setAttribute("userDetailsActiveCheckBox", "checked");
        } else {
            request.setAttribute("userDetailsActiveCheckBox", "");
        }

        if (formAdminUser) {
            request.setAttribute("userDetailsAdminCheckBox", "checked");
        } else {
            request.setAttribute("userDetailsAdminCheckBox", "");
        }
    }
}
