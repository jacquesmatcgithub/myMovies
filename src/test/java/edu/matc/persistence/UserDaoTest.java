package edu.matc.persistence;

import edu.matc.entity.Movie;
import edu.matc.entity.ViewingHabit;
import edu.matc.util.Database;
import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    UserDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    /**
     * Gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(7, users.size());
    }


    /**
     * This method was not built yet. I am using test driven development to
     * build it.
     */
    @Test
    void getByIDSuccess() {
        User retrievedUser = dao.getById(4);
        assertNotNull(retrievedUser);
        assertEquals("Lucy", retrievedUser.getFirstName());


        Set<ViewingHabit> habits = retrievedUser.getViewingHabits();
        List<ViewingHabit> habitList = new ArrayList<>(habits);

        int habitCount = habitList.size();

        if (habitCount > 0) {
            logger.debug("ViewvingHabit.getMovieId: " + habitList.get(0).getMovieId());
        }



    }


    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User(
                "ppan",
                "secret",
                "Peter",
                "Pan",
                TRUE,
                TRUE,
                LocalDate.parse("2018-01-20"),
                "Grand Rapids",
                "MI");

        int id = dao.insert(newUser);

        assertNotEquals(0,id);

        User insertedUser = dao.getById(id);

        assertEquals("Peter", insertedUser.getFirstName());

        if (newUser.equals(insertedUser)) {
            logger.info("newUser is equal to insertedUser");
        }
    }



    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(7, users.size());
    }


    /**
     * Verify the successful save/update of a user.
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";

        User userToUpdate = dao.getById(1);

        userToUpdate.setLastName(newLastName);

        dao.saveOrUpdate(userToUpdate);

        User retrievedUser = dao.getById(1);

        assertEquals(newLastName, retrievedUser.getLastName());
    }


    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("firstName", "Jacques");
        assertEquals(2, users.size());
    }


    /**
     * Verify successful get by boolean property (equal match)
     */
    @Test
    void getByBooleanPropertyEqualSuccess() {
        List<User> users = dao.getByBooleanPropertyEqual("admin", TRUE);
        assertEquals(3, users.size());
    }


    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "user");
        assertEquals(1, users.size());
    }


    @Test
    void insertWithViewingHabit() {
        User newUser = new User(
                "jbond",
                "secret",
                "James",
                "Bond",
                TRUE,
                TRUE,
                LocalDate.parse("2018-04-16"),
                "Birmingham",
                "AL");

        Movie newMovie = new Movie(
                "After Hours",
                "/s5XkBqUMwE0wQv9NY0XERs64cgs.jpg",
                "test",
                "test",
                "test",
                2,
                "afterhours",
                "jfourie",
                9999,
                "IC",
                newUser);

        ViewingHabit newViewingHabit = new ViewingHabit(
                12,
                LocalDate.parse("2018-04-16"),
                55,
                "Clear",
                "mostlycloudy",
                "http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif",
                newUser,
                newMovie);

        newUser.addViewingHabit(newViewingHabit);
        newUser.addMovie(newMovie);

        int id = dao.insert(newUser);

        assertNotEquals(0,id);

        User insertedUser = dao.getById(id);

        assertEquals("James", insertedUser.getFirstName());

    }

}