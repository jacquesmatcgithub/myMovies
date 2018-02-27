package edu.matc.persistence;

import edu.matc.test.util.Database;
import edu.matc.entity.MetadataTmdb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type MetadataTmdb dao test.
 */
class MetadataTmdbDaoTest {

    MetadataTmdbDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new MetadataTmdbDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets all metadata success.
     */
    @Test
    void getAllMetadataSuccess() {
        List<MetadataTmdb> metadata = dao.getAllMetadata();
        assertEquals(1, metadata.size());
    }


    /**
     * This method was not built yet. I am using test driven development to
     * build it.
     */
    @Test
    void getByIDSuccess() {
        MetadataTmdb retrievedMetadataTmdb = dao.getById(1);
        assertNotNull(retrievedMetadataTmdb);
        assertEquals("w92", retrievedMetadataTmdb.getLogoSize());

    }



    @Test
    void updateSuccess() {
        String newBackdropSize = "w780";

        MetadataTmdb metadataTmdbToUpdate = dao.getById(1);

        metadataTmdbToUpdate.setBackdropSize(newBackdropSize);

        dao.saveOrUpdate(metadataTmdbToUpdate);

        MetadataTmdb retrievedMetadataTmdb = dao.getById(1);

        assertEquals(newBackdropSize, retrievedMetadataTmdb.getBackdropSize());
    }
}