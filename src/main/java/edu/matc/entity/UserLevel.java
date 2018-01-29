package edu.matc.entity;

/**
 * A class to represent a user level.
 *
 * @author Jacques Fourie
 */
public class UserLevel {
    private int level;
    private String description;
    private boolean admin;

    /**
     * Instantiates a new User level.
     */
    public UserLevel() {

    }

    /**
     * Instantiates a new User level.
     *
     * @param level       the level
     * @param description the description
     * @param admin       the admin
     */
    public UserLevel(int level, String description, boolean admin) {
        this.level = level;
        this.description = description;
        this.admin = admin;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
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
     * Is admin boolean.
     *
     * @return the boolean
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Sets admin.
     *
     * @param admin the admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "level=" + level +
                ", description='" + description + '\'' +
                ", admin=" + admin +
                '}';
    }


}