package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Movie.
 */
@Entity(name = "ViewingHabit")
@Table(name = "viewing_habit")  // The @Table tag is case sensitive REMEMBER THAT!!!  Example: ="user"  vs  "=User"
public class ViewingHabit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "movie_id", updatable = false, insertable = false)
    private int movieId;

    @Column(name = "date_watched")
    private LocalDate dateWatched;

    @Column(name = "temp")
    private int temp;

    @Column(name = "weather_conditions")
    private String weatherConditions;

    @Column(name = "icon_name")
    private String iconName;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    /**
     * Instantiates a new Viewing habit.
     */
    public ViewingHabit() {
    }

    /**
     * Instantiates a new Viewing habit.
     *
     * @param movieId           the movie id
     * @param dateWatched       the date watched
     * @param temp              the temp
     * @param weatherConditions the weather conditions
     * @param iconName       the gif location
     * @param user              the user
     * @param movie             the movie
     */
    public ViewingHabit(int movieId,
                        LocalDate dateWatched,
                        int temp,
                        String weatherConditions,
                        String iconName,
                        User user,
                        Movie movie) {
        this.movieId = movieId;
        this.dateWatched = dateWatched;
        this.temp = temp;
        this.weatherConditions = weatherConditions;
        this.iconName = iconName;
        this.user = user;
        this.movie = movie;
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
     * Gets movie id.
     *
     * @return the movie id
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Sets movie id.
     *
     * @param movieId the movie id
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * Gets date watched.
     *
     * @return the date watched
     */
    public LocalDate getDateWatched() {
        return dateWatched;
    }

    /**
     * Sets date watched.
     *
     * @param dateWatched the date watched
     */
    public void setDateWatched(LocalDate dateWatched) {
        this.dateWatched = dateWatched;
    }


    /**
     * Gets temp.
     *
     * @return the temp
     */
    public int getTemp() {
        return temp;
    }

    /**
     * Sets temp.
     *
     * @param temp the temp
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }

    /**
     * Gets weather conditions.
     *
     * @return the weather conditions
     */
    public String getWeatherConditions() {
        return weatherConditions;
    }

    /**
     * Sets weather conditions.
     *
     * @param weatherConditions the weather conditions
     */
    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    /**
     * Gets gif location.
     *
     * @return the gif location
     */
    public String geticonName() {
        return iconName;
    }

    /**
     * Sets gif location.
     *
     * @param iconName the gif location
     */
    public void seticonName(String iconName) {
        this.iconName = iconName;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets movie.
     *
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets movie.
     *
     * @param movie the movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewingHabit that = (ViewingHabit) o;
        return id == that.id &&
                movieId == that.movieId &&
                temp == that.temp &&
                Objects.equals(dateWatched, that.dateWatched) &&
                Objects.equals(weatherConditions, that.weatherConditions) &&
                Objects.equals(iconName, that.iconName) &&
                Objects.equals(user, that.user) &&
                Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, movieId, dateWatched, temp, weatherConditions, iconName, user, movie);
    }

    @Override
    public String toString() {
        return "ViewingHabit{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", dateWatched=" + dateWatched +
                ", temp=" + temp +
                ", weatherConditions=" + weatherConditions +
                ", iconName=" + iconName +
                '}';
    }
}
