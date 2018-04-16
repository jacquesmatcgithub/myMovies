package edu.matc.persistence;

import edu.matc.entity.ViewingHabit;
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

public class ViewingHabitDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * Gets all viewingHabits.
     *
     * @return the all viewingHabits
     */
    public List<ViewingHabit> getAllViewingHabits() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ViewingHabit> query = builder.createQuery(ViewingHabit.class);
        Root<ViewingHabit> root = query.from(ViewingHabit.class);
        List<ViewingHabit> viewingHabits = session.createQuery(query).getResultList();

        session.close();

        return viewingHabits;

    }



    /**
     * Gets a viewingHabit by ID
     * @param id
     * @return a viewingHabit
     */
    public ViewingHabit getById(int id) {

        Session session = sessionFactory.openSession();

        // This uses the unique ID (@Id) defined in the viewingHabit.java
        // When searching by the unique id you don't have to set up
        // all the CriteriaBuilder stuff.
        ViewingHabit viewingHabit = session.get(ViewingHabit.class, id);

        session.close();

        return viewingHabit;

    }

    /**
     * update viewingHabit
     * @param viewingHabit  ViewingHabit to be inserted or updated
     */
    public void saveOrUpdate(ViewingHabit viewingHabit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(viewingHabit);
        transaction.commit();
        session.close();
    }

    /**
     * update viewingHabit
     * @param viewingHabit  ViewingHabit to be inserted or updated
     */
    public int insert(ViewingHabit viewingHabit) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(viewingHabit);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a viewingHabit
     * @param viewingHabit ViewingHabit to be deleted
     */
    public void delete(ViewingHabit viewingHabit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(viewingHabit);
        transaction.commit();
        session.close();
    }


    /** Return a list of all viewingHabits
     *
     * @return All viewingHabits
     */
    public List<ViewingHabit> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ViewingHabit> query = builder.createQuery( ViewingHabit.class );
        Root<ViewingHabit> root = query.from(ViewingHabit.class );
        List<ViewingHabit> viewingHabits = session.createQuery( query ).getResultList();

        logger.debug("The list of viewingHabits " + viewingHabits);
        session.close();

        return viewingHabits;
    }

    /**
     * Get viewingHabit by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<ViewingHabit> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for viewingHabit with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ViewingHabit> query = builder.createQuery( ViewingHabit.class );
        Root<ViewingHabit> root = query.from(ViewingHabit.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));

        List<ViewingHabit> viewingHabits = session.createQuery( query ).getResultList();

        session.close();
        return viewingHabits;
    }

    /**
     * Get viewingHabit by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<ViewingHabit> getByIntPropertyEqual(String propertyName, int value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for viewingHabit with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ViewingHabit> query = builder.createQuery( ViewingHabit.class );
        Root<ViewingHabit> root = query.from(ViewingHabit.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));

        List<ViewingHabit> viewingHabits = session.createQuery( query ).getResultList();

        session.close();
        return viewingHabits;
    }

    /**
     * Get viewingHabit by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<ViewingHabit> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for viewingHabit with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ViewingHabit> query = builder.createQuery( ViewingHabit.class );
        Root<ViewingHabit> root = query.from( ViewingHabit.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<ViewingHabit> viewingHabits = session.createQuery( query ).getResultList();
        session.close();
        return viewingHabits;
    }

}

