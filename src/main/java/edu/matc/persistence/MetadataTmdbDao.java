package edu.matc.persistence;

import edu.matc.entity.MetadataTmdb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MetadataTmdbDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * Gets all Metadata.
     *
     * @return the all Metadata
     */
    public List<MetadataTmdb> getAllMetadata() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MetadataTmdb> query = builder.createQuery(MetadataTmdb.class);
        Root<MetadataTmdb> root = query.from(MetadataTmdb.class);
        List<MetadataTmdb> Metadata = session.createQuery(query).getResultList();

        session.close();

        return Metadata;

    }


    /**
     * Gets a metadataTmdb by ID
     * @param id
     * @return a metadataTmdb
     */
    public MetadataTmdb getById(int id) {

        Session session = sessionFactory.openSession();

        // This uses the unique ID (@Id) defined in the metadataTmdb.java
        // When searching by the unique id you don't have to set up
        // all the CriteriaBuilder stuff.
        MetadataTmdb metadataTmdb = session.get(MetadataTmdb.class, id);

        session.close();

        return metadataTmdb;

    }

    /**
     * update metadataTmdb
     * @param metadataTmdb  MetadataTmdb to be inserted or updated
     */
    public void saveOrUpdate(MetadataTmdb metadataTmdb) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(metadataTmdb);
        transaction.commit();
        session.close();
    }


}

