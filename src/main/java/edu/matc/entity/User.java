package edu.matc.entity;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private int level;
    private boolean active;



    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userId    the user id
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param level     the level
     * @param active    the active
     */
    public User(String userId,
                String password,
                String firstName,
                String lastName,
                int level,
                boolean active) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.active = active;
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
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets level
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
     * Gets avtive flag.
     *
     * @return the active flag
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Sets active flag.
     *
     * @param active the active flag
     */
    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level=" + level +
                ", active='" + active +
                '}';
    }


}