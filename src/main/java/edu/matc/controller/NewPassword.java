package edu.matc.controller;

import edu.matc.persistence.*;
import edu.matc.entity.*;

import java.io.*;
import java.util.List;
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
    private static final String INVALID_PASSWORD_MSG = "Invalid Password";
    private static final String PASSWORD_CHANGED_MSG = "Password Changed";

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

        request.setAttribute("passwordMessage", changePassword(currentUser, currentPassword, newPassword));

        String url = "/login-failed.jsp";
        if (userLevel.equals(ADMIN)) {
            url = "/signed-in-admin.jsp";
        } else if (userLevel.equals(COLLECTOR)) {
            url = "/signed-in-collector.jsp";
        }


        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * The passwordChanged method is used to change a user's password.
     * @param currentPassword
     * @param newPassword
     * @return Password change message
     */
    private String changePassword(String currentUser, String currentPassword, String newPassword) {
        if (currentUser.isEmpty() ||
                newPassword.equals(currentPassword) ||
                currentPassword.isEmpty() ||
                newPassword.isEmpty()) {
            return INVALID_PASSWORD_MSG;
        }
        GenericDao dao = new GenericDao(User.class);

        List<User> users = dao.getByPropertyEqual("loginId", currentUser);

        if (users.size() == 0) {
            return INVALID_PASSWORD_MSG;
        }

        if (!currentPassword.equals(users.get(0).getPassword())) {
            return INVALID_PASSWORD_MSG;
        }

        users.get(0).setPassword(newPassword);

        dao.saveOrUpdate(users.get(0));

        return PASSWORD_CHANGED_MSG;
    }

}
