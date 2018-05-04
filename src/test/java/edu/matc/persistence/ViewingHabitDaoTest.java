package edu.matc.persistence;

import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.entity.ViewingHabit;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ViewingHabitDaoTest {

    ViewingHabitDao dao;

    @BeforeEach
    void setUp() {
        dao = new ViewingHabitDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    @Test
    void saveOrUpdateTest() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(3);
        Set<Movie> movies = user.getMovies();
        List<Movie> movieList = new ArrayList<>(movies);
        Movie movie = movieList.get(0);

        ViewingHabit viewingHabit = new ViewingHabit(
                2,
                LocalDate.parse("2017-01-01"),
                68,
                "Light Snow",
                 "mostlycloudy",
                 "http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif",
                 user,
                movie);
        dao.saveOrUpdate(viewingHabit);
    }

    @Test
    void insertTest() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(3);
        Set<Movie> movies = user.getMovies();
        List<Movie> movieList = new ArrayList<>(movies);
        Movie movie = movieList.get(0);

        ViewingHabit viewingHabit = new ViewingHabit(
                2,
                LocalDate.parse("2017-01-01"),
                68,
                "Light Snow",
                "mostlycloudy",
                "http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif",
                user,
                movie);
        dao.insert(viewingHabit);
    }

    @Test
    void deleteTest() {
        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getById(1);
        Set<ViewingHabit> viewingHabits = movie.getViewingHabits();
        List<ViewingHabit> habitList = new ArrayList<>(viewingHabits);

        ViewingHabitDao viewingHabitDao = new ViewingHabitDao();


        for (ViewingHabit habit : habitList) {
            viewingHabitDao.delete(habit);
        }

    }
}