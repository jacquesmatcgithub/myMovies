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
//*TODO Update the javadoc

/**
 * The type Crud user.
 */
@WebServlet (
        name = "CrudUserServlet",
        urlPatterns = "/crudUser"
)
public class CrudUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The BUTTON_PRESSED constant is the name of every button on the Admin TmdbSearchPage.
     */
    private static final String BUTTON_PRESSED = "adminPageButton";
    
    private static final String BUTTON_ADD_UPDATE_USER = "Add/Update";
    private static final String BUTTON_DELETE_USER = "Delete";

    private static final String MSG_USER_ADDED_UPDATED_SUCCESSFULLY = "Added/updated successfully";
    private static final String MSG_USER_DELETED_SUCCESSFULLY = "User deleted successfully";
    private static final String MSG_ENTER_FIELD = "Please enter field";

    private static final int FORM_FIELD_LOGINID_EMPTY = 1;
    private static final int FORM_FIELD_FIRSTNAME_EMPTY = 2;
    private static final int FORM_FIELD_LASTNAME_EMPTY = 3;
    private static final int FORM_FIELD_DATEACTIVE_EMPTY = 4;
    private static final int FORM_FIELD_CITY_EMPTY = 5;
    private static final int FORM_FIELD_STATE_EMPTY = 6;
    private static final int FORM_FIELD_NONE_EMPTY = 99;


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
        ServletContext servletContext = getServletContext();
        AdminPage adminPage = (AdminPage)servletContext.getAttribute("adminPage");

        UserDao userDao = new UserDao();

        String url = "/signed-in-admin.jsp";
        String userDetailsMessage = "";

        HttpSession session = request.getSession();

        // Find which button was pressed on the Admin TmdbSearchPage
        String buttonPressed = request.getParameter(BUTTON_PRESSED);


        // Capture all the user details fields for processing and redisplay
        String formLoginId = request.getParameter("loginId");
        String formFirstName = request.getParameter("firstName");
        String formLastName = request.getParameter("lastName");
        LocalDate formDateActive = LocalDate.parse(request.getParameter("dateActive"));
        String formCity = request.getParameter("city");
        String formState = request.getParameter("state");

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
            case BUTTON_ADD_UPDATE_USER:
                userDetailsMessage = addUpdateUser(
                        request,
                        userDao,
                        formLoginId,
                        formFirstName,
                        formLastName,
                        formDateActive,
                        formAdminUser,
                        formActiveUser,
                        formCity,
                        formState);
                break;
            case BUTTON_DELETE_USER:
                userDetailsMessage = deleteUser(request, userDao);
                break;
        }

        request.setAttribute("userDetailsMessage", userDetailsMessage);

        adminPage.load(request, formLoginId);


        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     *
     * @param request
     * @param userDao
     * @param formLoginId
     * @param formFirstName
     * @param formLastName
     * @param formDateActive
     * @param formAdminUser
     * @param formActiveUser
     * @param formCity
     * @param formState
     * @return
     */
    private String addUpdateUser(HttpServletRequest request, UserDao userDao,  String formLoginId, String formFirstName,
                              String formLastName, LocalDate formDateActive, boolean formAdminUser,
                              boolean formActiveUser, String formCity, String formState) {

        int emptyField = findFirstEmptyField(request,
                formLoginId,
                formFirstName,
                formLastName,
                formDateActive,
                formCity,
                formState);

        if (emptyField != FORM_FIELD_NONE_EMPTY) {
            return MSG_ENTER_FIELD;
        }

        
        List<User> users = userDao.getByPropertyEqual("loginId", formLoginId);

        if (users.size() == 0) {
            User newUser = new User(
                    formLoginId, "temp",
                    formFirstName,
                    formLastName,
                    formAdminUser,
                    formActiveUser,
                    formDateActive,
                    formCity,
                    formState);

            int id = userDao.insert(newUser);
        } else {
            User userToUpdate = users.get(0);
            userToUpdate.setLoginId(formLoginId);
            userToUpdate.setFirstName(formFirstName);
            userToUpdate.setLastName(formLastName);
            userToUpdate.setDateActive(formDateActive);
            userToUpdate.setAdmin(formAdminUser);
            userToUpdate.setActive(formActiveUser);
            userToUpdate.setCity(formCity);
            userToUpdate.setState(formState);

            userDao.saveOrUpdate(userToUpdate);
        }

        return MSG_USER_ADDED_UPDATED_SUCCESSFULLY;
    }


    /**
     *
     * @param request
     * @param userDao
     * @return
     */
    private String deleteUser(HttpServletRequest request, UserDao userDao) {
        return MSG_USER_DELETED_SUCCESSFULLY;
    }


    /**
     *
     * @param request
     * @param formLoginId
     * @param formFirstName
     * @param formLastName
     * @param formDateActive
     * @param formCity
     * @param formState
     * @return
     */
    private int findFirstEmptyField(HttpServletRequest request, String formLoginId, String formFirstName,
                                    String formLastName, LocalDate formDateActive,
                                    String formCity, String formState) {
        
        request.removeAttribute("loginIdAutofocus");
        request.removeAttribute("firstNameAutofocus");
        request.removeAttribute("lastNameAutofocus");
        request.removeAttribute("dateActiveAutofocus");
        request.removeAttribute("cityAutofocus");
        request.removeAttribute("stateAutofocus");

        if (formLoginId.isEmpty()) {
            request.setAttribute("loginIdAutofocus", "autofocus");
            return FORM_FIELD_LOGINID_EMPTY;
        } else if (formFirstName.isEmpty()) {
            request.setAttribute("firstNameAutofocus", "autofocus");
            return FORM_FIELD_FIRSTNAME_EMPTY;
        } else if (formLastName.isEmpty()) {
            request.setAttribute("lastNameAutofocus", "autofocus");
            return FORM_FIELD_LASTNAME_EMPTY;
        } else if (formDateActive.toString().isEmpty()) {
            request.setAttribute("dateActiveAutofocus", "autofocus");
            return FORM_FIELD_DATEACTIVE_EMPTY;
        } else if (formCity.isEmpty()) {
            request.setAttribute("cityAutofocus", "autofocus");
            return FORM_FIELD_CITY_EMPTY;
        } else if (formState.isEmpty()) {
            request.setAttribute("stateAutofocus", "autofocus");
            return FORM_FIELD_STATE_EMPTY;
        } else {
            return FORM_FIELD_NONE_EMPTY;
        }
    }
}
