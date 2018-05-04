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



}

