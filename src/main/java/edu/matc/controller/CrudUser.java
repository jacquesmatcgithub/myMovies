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

import static java.lang.Boolean.TRUE;

@WebServlet (
        name = "CrudUserServlet",
        urlPatterns = "/crudUser"
)
public class CrudUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private static final String USER_DETAILS_BUTTON = "userDetailsButton";
    private static final String BUTTON_ADD_UPDATE_USER = "Add/Update";
    private static final String BUTTON_SEARCH_USER = "Search";
    private static final String BUTTON_DELETE_USER = "Delete";
    private static final String USER_ADDED_UPDATED_SUCCESSFULLY = "User added/updated successfully";
    private static final String USER_FOUND = "User found";
    private static final String USER_NOT_FOUND = "User not found";
    private static final String USER_UPDATED_SUCCESSFULLY = "User updated successfully";
    private static final String USER_DELETED_SUCCESSFULLY = "User deleted successfully";


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
        String url = "/jsp/signed-in-admin.jsp";
        String userDetailsMessage = "";

        HttpSession session = request.getSession();

        String buttonPressed = request.getParameter(USER_DETAILS_BUTTON);

        String formUserId = request.getParameter("userId");
        String formFirstName = request.getParameter("firstName");
        String formLastName = request.getParameter("lastName");
        String formCatalogName = request.getParameter("catalogName");
        LocalDate formDateActive = LocalDate.parse(request.getParameter("dateActive"));

        boolean formAdminUser = false;

        if (request.getParameter("adminUser") != null) {
            formAdminUser = true;
        }

        boolean formActiveUser = false;

        if (request.getParameter("activeUser") != null) {
            formActiveUser = true;
        }


        switch (buttonPressed) {
            case BUTTON_ADD_UPDATE_USER:
                userDetailsMessage = addNewUser(request, userDao, formUserId, formFirstName, formLastName, formCatalogName,
                        formDateActive, formAdminUser, formActiveUser);
                break;
            case BUTTON_SEARCH_USER:
                userDetailsMessage = searchUser(request);
                break;
            case BUTTON_DELETE_USER:
                userDetailsMessage = deleteUser(request);
                break;
        }

        request.setAttribute("userDetailsMessage", userDetailsMessage);

        request.setAttribute("users", userDao.getAllUsers());

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private String addNewUser(HttpServletRequest request, UserDao userDao,  String formUserId, String formFirstName,
                              String formLastName, String formCatalogName, LocalDate formDateActive, boolean formAdminUser,
                              boolean formActiveUser) {

        List<User> users = userDao.getByPropertyEqual("userId", formUserId);
        if (users.size() == 0) {
            User newUser = new User(formUserId, "temp", formFirstName, formLastName, formAdminUser, formActiveUser, formDateActive);
            int id = userDao.insert(newUser);
        } else {
            User userToUpdate = users.get(0);
            userToUpdate.setUserId(formUserId);
            userToUpdate.setFirstName(formFirstName);
            userToUpdate.setLastName(formLastName);
            userToUpdate.setDateActive(formDateActive);
            userToUpdate.setAdmin(formAdminUser);
            userToUpdate.setActive(formActiveUser);

            userDao.saveOrUpdate(userToUpdate);
        }

        return USER_ADDED_UPDATED_SUCCESSFULLY;
    }

    private String searchUser(HttpServletRequest request) {
        return USER_FOUND;
    }

    private String deleteUser(HttpServletRequest request) {
        return USER_DELETED_SUCCESSFULLY;
    }
}
