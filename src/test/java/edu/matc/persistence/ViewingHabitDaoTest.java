package edu.matc.persistence;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.entity.ViewingHabit;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewingHabitDaoTest {

    ViewingHabitDao dao;

    @BeforeEach
    void setUp() {
        dao = new ViewingHabitDao();

        edu.matc.test.util.Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllViewingHabitsTest() {
        List<ViewingHabit> viewingHabits = dao.getAll();

        assertEquals(4, viewingHabits.size());
    }


    @Test
    void getByIdTest() {
        ViewingHabit viewingHabit = dao.getById(1);

        int expectedValue = 1;
        int actualValue = viewingHabit.getMovieId();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    void saveOrUpdateTest() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(3);

        ViewingHabit viewingHabit = new ViewingHabit(
                2,
                LocalDate.parse("2017-01-01"),
                68,
                true,
                 true,
                 true,
                 true,
                 true,
                 true,
                 user);
        dao.saveOrUpdate(viewingHabit);
    }

/*
    @Test
    void getByIntPropertyEqualTest1() {
        List<ViewingHabit> habits = dao.getByIntPropertyEqual("movieId", 1);

        int expectedValue = 2;
        int actualValue = habits.size();

        assertEquals(expectedValue, actualValue);

    }


    @Test
    void getByIntPropertyEqualTest2() {
        List<ViewingHabit> habits = dao.getByIntPropertyEqual("userId", 3);

        int expectedValue = 2;
        int actualValue = habits.size();

        assertEquals(expectedValue, actualValue);

    }
*/
}