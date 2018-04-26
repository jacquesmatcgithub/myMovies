package edu.matc.persistence;

import edu.matc.entity.Role;
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

public class RoleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * Gets all roles.
     *
     * @return the all roles
     */
    public List<Role> getAllRoles() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        List<Role> roles = session.createQuery(query).getResultList();

        session.close();

        return roles;

    }



    /**
     * Gets a role by ID
     * @param id
     * @return a role
     */
    public Role getById(int id) {

        Session session = sessionFactory.openSession();

        // This uses the unique ID (@Id) defined in the role.java
        // When searching by the unique id you don't have to set up
        // all the CriteriaBuilder stuff.
        Role role = session.get(Role.class, id);

        session.close();

        return role;

    }

    /**
     * update role
     * @param role  Role to be inserted or updated
     */
    public void saveOrUpdate(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(role);
        transaction.commit();
        session.close();
    }

    /**
     * update role
     * @param role  Role to be inserted or updated
     */
    public int insert(Role role) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(role);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a role
     * @param role Role to be deleted
     */
    public void delete(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();
    }


    /** Return a list of all roles
     *
     * @return All roles
     */
    public List<Role> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery( Role.class );
        Root<Role> root = query.from(Role.class );
        List<Role> roles = session.createQuery( query ).getResultList();

        logger.debug("The list of roles " + roles);
        session.close();

        return roles;
    }

    /**
     * Get role by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Role> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for role with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery( Role.class );
        Root<Role> root = query.from(Role.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));

        List<Role> roles = session.createQuery( query ).getResultList();

        session.close();
        return roles;
    }

    /**
     * Get role by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Role> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for role with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery( Role.class );
        Root<Role> root = query.from( Role.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Role> roles = session.createQuery( query ).getResultList();
        session.close();
        return roles;
    }

}

