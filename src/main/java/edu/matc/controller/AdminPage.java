package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.persistence.MovieDao;
import edu.matc.persistence.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AdminPage {

    /**
     * This method populates the admin page as if the admin user clicked on the
     * first user in the list of users.
     * @param request
     */
    public void load(HttpServletRequest request) {

        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();

        populate(request,
                userDao,
                users.get(0).getLoginId(),
                users.get(0).getFirstName(),
                users.get(0).getLastName(),
                users.get(0).getDateActive(),
                users.get(0).getCity(),
                users.get(0).getState(),
                users.get(0).getAdmin(),
                users.get(0).getActive(),
                users,
                users.get(0).getMovies());
    }


    /**
     * This method populates the admin page as if the admin user clicked on the
     * login id passed as a parameter.
     * @param request
     * @param loginId
     */
    public void load(HttpServletRequest request, String loginId) {

        UserDao userDao = new UserDao();

        List<User> users = userDao.getByPropertyEqual("loginId", loginId);

        populate(request,
                userDao,
                users.get(0).getLoginId(),
                users.get(0).getFirstName(),
                users.get(0).getLastName(),
                users.get(0).getDateActive(),
                users.get(0).getCity(),
                users.get(0).getState(),
                users.get(0).getAdmin(),
                users.get(0).getActive(),
                userDao.getAllUsers(),
                users.get(0).getMovies());
    }


    /**
     * The populate method populates the four areas on the Admin TmdbSearchPage.
     * @param request
     * @param userDao
     * @param loginId
     * @param firstName
     * @param lastName
     * @param dateActive
     * @param adminUser
     * @param activeUser
     * @param users
     * @param movies
     */
    private void populate(HttpServletRequest request,
                          UserDao userDao,
                          String loginId,
                          String firstName,
                          String lastName,
                          LocalDate dateActive,
                          String city,
                          String state,
                          boolean adminUser,
                          boolean activeUser,
                          List<User> users,
                          Set<Movie> movies) {

        // User list area
        request.setAttribute("totalUserCount", users.size());
        request.setAttribute("users", users);



        // User details area
        request.setAttribute("detailsLoginId", loginId);
        request.setAttribute("detailsFirstName", firstName);
        request.setAttribute("detailsLastName", lastName);
        request.setAttribute("detailsDateActive", dateActive);
        request.setAttribute("detailsCity", city);
        request.setAttribute("detailsState", state);

        if (activeUser) {
            request.setAttribute("userDetailsActiveCheckBox", "checked");
        } else {
            request.setAttribute("userDetailsActiveCheckBox", "");
        }

        if (adminUser) {
            request.setAttribute("userDetailsAdminCheckBox", "checked");
        } else {
            request.setAttribute("userDetailsAdminCheckBox", "");
        }



        // Movie list area
        request.setAttribute("userMovieCount", movies.size());
        request.setAttribute("movies", movies);



        // Stats area
        users = userDao.getByBooleanPropertyEqual("admin", TRUE);
        request.setAttribute("adminUserCount", users.size());

        users = userDao.getByBooleanPropertyEqual("admin", FALSE);
        request.setAttribute("regularUserCount", users.size());

        MovieDao movieDao = new MovieDao();
        List<Movie> allMovies = movieDao.getAllMovies();
        request.setAttribute("totalNumberOfMovies", allMovies.size());
    }
}
