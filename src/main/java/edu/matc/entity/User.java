package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
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

    @Column(name = "user_password")
    private String userPassword;

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

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderBy(clause = "sort_key ASC")
    private Set<Movie> movies = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ViewingHabit> viewingHabits = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param loginId    the login id
     * @param password   the password
     * @param firstName  the first name
     * @param lastName   the last name
     * @param admin      the admin
     * @param active     the active
     * @param dateActive the date active
     * @param city       the city
     * @param state      the state
     */
    public User(String loginId,
                String password,
                String firstName,
                String lastName,
                boolean admin,
                boolean active,
                LocalDate dateActive,
                String city,
                String state) {

        this.loginId = loginId;
        this.userPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.active = active;
        this.dateActive = dateActive;
        this.city = city;
        this.state = state;
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
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setUserPassword(String password) {
        this.userPassword = password;
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
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
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

    /**
     * Gets viewing habits.
     *
     * @return the viewing habits
     */
    public Set<ViewingHabit> getViewingHabits() {
        return viewingHabits;
    }

    /**
     * Sets viewing habits.
     *
     * @param viewingHabits the viewing habits
     */
    public void setViewingHabits(Set<ViewingHabit> viewingHabits) {
        this.viewingHabits = viewingHabits;
    }

    /**
     * Add viewing habit.
     *
     * @param viewingHabit the viewing habit
     */
    public void addViewingHabit(ViewingHabit viewingHabit) {
        viewingHabits.add(viewingHabit);
        viewingHabit.setUser(this);
    }

    /**
     * Remove viewing habit.
     *
     * @param viewingHabit the viewing habit
     */
    public void removeViewingHabit(ViewingHabit viewingHabit) {
        viewingHabits.remove(viewingHabit);
        viewingHabit.setUser(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                admin == user.admin &&
                active == user.active &&
                Objects.equals(loginId, user.loginId) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(dateActive, user.dateActive) &&
                Objects.equals(city, user.city) &&
                Objects.equals(state, user.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, loginId, userPassword, firstName, lastName, admin, active, dateActive, city, state);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", admin=" + admin +
                ", active=" + active +
                ", dateActive=" + dateActive +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}