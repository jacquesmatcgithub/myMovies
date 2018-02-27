package edu.matc.persistence;

// import edu.matc.entity.Order;
import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The  Movie dao test.
 */
class MovieDaoTest {

    MovieDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new MovieDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
}

    /**
     * Gets all movies success.
     */
    @Test
    void getAllMoviesSuccess() {
        List<Movie> movies = dao.getAllMovies();
        assertEquals(9, movies.size());
    }

    /**
     * Gets some movies.
     */
    @Test
    void getSomeMovies() {
        List<Movie> movies = dao.getSomeMovies("u");
        assertEquals(1, movies.size());

    }

    /**
     * This method was not built yet. I am using test driven development to
     * build it.
     */
    @Test
    void getByIDSuccess() {
        Movie retrievedMovie = dao.getById(2);
        assertNotNull(retrievedMovie);
        assertEquals("War Games", retrievedMovie.getName());

    }


    /**
     * Verify successful insert of a movie
     */
    @Test
    void insertSuccess() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(1);

        Movie newMovie = new Movie(
                "After Hours",
                "s5XkBqUMwE0wQv9NY0XERs64cgs.jpg",
                "test",
                "test",
                "test",
                2,
                "afterhours",
                "jfourie",
                user);

        int id = dao.insert(newMovie);
        assertNotEquals(0,id);
        Movie insertedMovie = dao.getById(id);
        assertEquals("After Hours", insertedMovie.getName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/movieguide/html_single/Hibernate_Movie_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of movie
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all movies
     */
    @Test
    void getAllSuccess() {
        List<Movie> movies = dao.getAll();
        assertEquals(9, movies.size());
    }

    /**
     * Verifies that a movie gets saved/updated successfully.
     */
    @Test
    void updateSuccess() {
        String newName = "War Games Forever";

        Movie movieToUpdate = dao.getById(2);

        movieToUpdate.setName(newName);

        dao.saveOrUpdate(movieToUpdate);

        Movie retrievedMovie = dao.getById(2);

        assertEquals(newName, retrievedMovie.getName());
    }
    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Movie> movies = dao.getByPropertyEqual("sortKey", "bladerunner2048");
        assertEquals(1, movies.size());
        assertEquals(3, movies.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Movie> movies = dao.getByPropertyLike("name", "runner");
        assertEquals(2, movies.size());
    }
}