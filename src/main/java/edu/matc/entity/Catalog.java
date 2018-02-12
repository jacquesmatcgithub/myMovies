package edu.matc.entity;

import java.time.LocalDate;

/**
 * The type Catalog.
 */
public class Catalog {
    private int id;
    private String userId;
    private int catalogId;
    private String description;
    private LocalDate dateCreated;

    /**
     * Instantiates a new Catalog.
     */
    public Catalog() {

    }

    /**
     * Instantiates a new Catalog.
     *
     * @param id          the id
     * @param userId      the user id
     * @param catalogId   the catalog id
     * @param description the description
     * @param dateCreated the date created
     */
    public Catalog(int id, String userId, int catalogId, String description, LocalDate dateCreated) {
        this.id = id;
        this.userId = userId;
        this.catalogId = catalogId;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets catalog id.
     *
     * @return the catalog id
     */
    public int getCatalogId() {
        return catalogId;
    }

    /**
     * Sets catalog id.
     *
     * @param catalogId the catalog id
     */
    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets date created.
     *
     * @return the date created
     */
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets date created.
     *
     * @param dateCreated the date created
     */
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", catalogId=" + catalogId +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
