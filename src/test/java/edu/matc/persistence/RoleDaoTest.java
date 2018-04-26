package edu.matc.persistence;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    RoleDao roleDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        roleDao = new RoleDao();

        edu.matc.util.Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllRoles() {
        List<Role> roles = roleDao.getAllRoles();

        assertEquals(7, roles.size());

    }


    @Test
    void getById() {
        Role role = roleDao.getById(3);

        String expected = "regular";
        String actual = role.getRoleName();
        assertEquals(expected, actual);

        expected = "jfourie";
        actual = role.getLoginId();
        assertEquals(expected, actual);

    }

    @Test
    void saveOrUpdate() {
        int roleId = 5;

        Role role = roleDao.getById(roleId);
        String expected = "regular";
        String actual = role.getRoleName();
        assertEquals(expected, actual);

        role.setRoleName("admin");
        roleDao.saveOrUpdate(role);


        role = roleDao.getById(roleId);

        expected = "admin";
        actual = role.getRoleName();
        assertEquals(expected, actual);

    }

    @Test
    void insert() {
        User user = new User(
                "jbond",
                "secret",
                "James",
                "Bond",
                false,
                true,
                LocalDate.parse("2018-04-16"),
                "Birmingham",
                "AL");

        Role role = new Role (
                "regular",
                user.getLoginId(),
                user);

        roleDao.insert(role);

        List<Role> roles = roleDao.getByPropertyEqual("loginId", user.getLoginId());

        String expected = "";
        String actual = "";

        if (roles.size() > 0) {
            expected = "jbond";
            actual = roles.get(0).getLoginId();

            assertEquals(expected, actual);
        }

    }

    @Test
    void delete() {

        Role role = roleDao.getById(4);

        roleDao.delete(role);

    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}