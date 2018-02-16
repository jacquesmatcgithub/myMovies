package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author Jacques Fourie
 */

@Entity(name = "User")
@Table(name = "user")  // The @Table tag is case sensitive REMEMBER THAT!!!  Example: ="user"  vs  "=User"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "active")
    private boolean active;

    @Column(name = "date_active")
    private LocalDate dateActive;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Movie> movies = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    public User(String loginId, String password, String firstName, String lastName, boolean admin, boolean active, LocalDate dateActive) {
        this.loginId = loginId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.active = active;
        this.dateActive = dateActive;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets user id.
     *
     * @param loginId the user id
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
     * Gets admin
     *
     * @return the admin
     */
    public boolean getAdmin() {
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

    /**
     * Is admin boolean.
     *
     * @return the boolean
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Gets date active.
     *
     * @return the date active
     */
    public LocalDate getDateActive() {
        return dateActive;
    }

    /**
     * Sets date active.
     *
     * @param dateActive the date active
     */
    public void setDateActive(LocalDate dateActive) {
        this.dateActive = dateActive;
    }


    /**
     * Gets movies.
     *
     * @return the movies
     */
    public Set<Movie> getMovies() {
        return movies;
    }

    /**
     * Sets movies.
     *
     * @param movies the movies
     */
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Add movie.
     *
     * @param movie the movie
     */
    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.setUser(this);
    }

    /**
     * Remove movie.
     *
     * @param movie the movie
     */
    public void removeMovie(Movie movie) {
        movies.remove(movie);
        movie.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", admin=" + admin +
                ", active=" + active +
                '}';
    }
}