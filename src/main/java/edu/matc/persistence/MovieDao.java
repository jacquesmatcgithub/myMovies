package edu.matc.persistence;

import edu.matc.entity.Movie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * Gets all movies.
     *
     * @return the all movies
     */
    public List<Movie> getAllMovies() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Movie> query = builder.createQuery(Movie.class);
        Root<Movie> root = query.from(Movie.class);
        List<Movie> movies = session.createQuery(query).getResultList();

        session.close();

        return movies;

    }

    public List<Movie> getSomeMovies(String searchTerm) {

        logger.debug("Searching for: {}", searchTerm);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Movie> query = builder.createQuery(Movie.class);
        Root<Movie> root = query.from(Movie.class);
        Expression<String> propertyPath = root.get("userId");
        query.where(builder.like(propertyPath, searchTerm + "%"));
        List<Movie> movies = session.createQuery(query).getResultList();

        session.close();

        return movies;

    }



    /**
     * Gets a movie by ID
     * @param id
     * @return a movie
     */
    public Movie getById(int id) {

        Session session = sessionFactory.openSession();

        // This uses the unique ID (@Id) defined in the movie.java
        // When searching by the unique id you don't have to set up
        // all the CriteriaBuilder stuff.
        Movie movie = session.get(Movie.class, id);

        session.close();

        return movie;

    }

    /**
     * update movie
     * @param movie  Movie to be inserted or updated
     */
    public void saveOrUpdate(Movie movie) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(movie);
        transaction.commit();
        session.close();
    }

    /**
     * update movie
     * @param movie  Movie to be inserted or updated
     */
    public int insert(Movie movie) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(movie);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a movie
     * @param movie Movie to be deleted
     */
    public void delete(Movie movie) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(movie);
        transaction.commit();
        session.close();
    }


    /** Return a list of all movies
     *
     * @return All movies
     */
    public List<Movie> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Movie> query = builder.createQuery( Movie.class );
        Root<Movie> root = query.from(Movie.class );
        List<Movie> movies = session.createQuery( query ).getResultList();

        logger.debug("The list of movies " + movies);
        session.close();

        return movies;
    }

    /**
     * Get movie by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Movie> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for movie with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Movie> query = builder.createQuery( Movie.class );
        Root<Movie> root = query.from(Movie.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));

        List<Movie> movies = session.createQuery( query ).getResultList();

        session.close();
        return movies;
    }

    /**
     * Get movie by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Movie> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for movie with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Movie> query = builder.createQuery( Movie.class );
        Root<Movie> root = query.from( Movie.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));
//        query.orderBy(builder.asc(root.get("Movie_.sort_key")));

        List<Movie> movies = session.createQuery( query ).getResultList();
        session.close();
        return movies;
    }

}

