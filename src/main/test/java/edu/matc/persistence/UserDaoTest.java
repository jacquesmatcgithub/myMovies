package edu.matc.persistence;

// import edu.matc.entity.Order;
import edu.matc.test.util.Database;
import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

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
        assertEquals(5, users.size());
    }

    /**
     * Gets some users.
     */
    @Test
    void getSomeUsers() {
        List<User> users = dao.getSomeUsers("u");
        assertEquals(3, users.size());

    }

    /**
     * This method was not built yet. I am using test driven development to
     * build it.
     */
    @Test
    void getByIDSuccess() {
        User retrievedUser = dao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("Jacques", retrievedUser.getFirstName());

    }


    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("ppan", "secret", "Peter", "Pan", TRUE, TRUE, LocalDate.parse("2018-01-20"));
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Peter", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful insert of a user with order
     */
    /**
    @Test
    void insertWithOrderSuccess() {

        User newUser = new User("Fred", "Flintstone", "fflintstone", LocalDate.parse("1968-01-01"));

        String orderDescription = "Order 1";
        Order order = new Order(orderDescription, newUser);

        newUser.addOrder(order);


        int id = dao.insert(newUser);


        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Fred", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getOrders().size());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }
    **/
    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(5, users.size());
    }

    @Test
    void updateSuccess() {
        String newLastName = "Davis";

        User userToUpdate = dao.getById(4);

        userToUpdate.setLastName(newLastName);

        dao.saveOrUpdate(userToUpdate);

        User retrievedUser = dao.getById(4);

        assertEquals(newLastName, retrievedUser.getLastName());
    }
    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("lastName", "Fourie");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "user");
        assertEquals(3, users.size());
    }
}