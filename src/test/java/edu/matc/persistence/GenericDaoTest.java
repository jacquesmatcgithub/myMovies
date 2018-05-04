package edu.matc.persistence;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        edu.matc.util.Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }



    @Test
    void getById() {
        GenericDao<User> dao = new GenericDao<>(User.class);
        User user = dao.getById(1);
        String testFirstName = "Bad";
        String actualFirstName = user.getFirstName();

        assertEquals(testFirstName, actualFirstName);
    }

    @Test
    void delete() {
        GenericDao<User> dao = new GenericDao<>(User.class);
        User user = dao.getById(2);
        String loginId = user.getLoginId();

        dao.delete(user);
        List<User> users = dao.getByPropertyEqual("loginId", loginId);

        int userCount = users.size();


        assertEquals(userCount, 0);
    }

    @Test
    void getAll() {
        GenericDao<Movie> dao = new GenericDao<>(Movie.class);
        List<Movie> movies = dao.getAll();

        int actualCount = movies.size();
        int testCount = 25;
//        int testCount = actualCount;

        assertEquals(testCount, actualCount);


    }

    @Test
    void getByPropertyEqual() {
        GenericDao<Movie> dao = new GenericDao<>(Movie.class);
        List<Movie> movies = dao.getByPropertyEqual("name", "Abyss");

        int testCount = 1;
        int actualCount = movies.size();

        assertEquals(testCount, actualCount);


    }

    @Test
    void insert() {

        GenericDao<User> dao = new GenericDao<>(User.class);


        User newUser = new User(
                "ppan",
                "secret",
                "Peter",
                "Pan",
                true,
                true,
                LocalDate.parse("2018-01-20"),
                "Grand Rapids",
                "MI");

        int id = dao.insert(newUser);

        assertNotEquals(0,id);

        User insertedUser = dao.getById(id);

        assertEquals("Peter", insertedUser.getFirstName());

    }

    @Test
    void saveOrUpdate() {
        GenericDao<User> dao = new GenericDao<>(User.class);
        String newLastName = "Davis";

        User userToUpdate = dao.getById(1);

        userToUpdate.setLastName(newLastName);

        dao.saveOrUpdate(userToUpdate);

        User retrievedUser = dao.getById(1);

        assertEquals(newLastName, retrievedUser.getLastName());
    }

    @Test
    void getByPropertyLike() {
        GenericDao<Movie> dao = new GenericDao<>(Movie.class);
        List<Movie> movies = dao.getByPropertyLike("name", "The");

        int testCount = 4;
        int actualCount = movies.size();

        assertEquals(testCount, actualCount);

    }
}