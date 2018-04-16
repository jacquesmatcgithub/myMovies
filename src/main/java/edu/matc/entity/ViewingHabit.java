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

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "date_watched")
    private LocalDate dateWatched;

    @Column(name = "season_id")
    private int seasonId;

    @Column(name = "weather_id")
    private int weatherId;

    @Column(name = "user_id")
    private int userId;


    /**
     * Instantiates a new Viewing habit.
     */
    public ViewingHabit() {
    }

    /**
     * Instantiates a new Viewing habit.
     *
     * @param movieId     the movie id
     * @param dateWatched the date watched
     * @param seasonId    the season id
     * @param weatherId   the weather id
     * @param userId      the user id
     */
    public ViewingHabit(int movieId, LocalDate dateWatched, int seasonId, int weatherId, int userId) {
        this.movieId = movieId;
        this.dateWatched = dateWatched;
        this.seasonId = seasonId;
        this.weatherId = weatherId;
        this.userId = userId;
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
     * Gets season id.
     *
     * @return the season id
     */
    public int getSeasonId() {
        return seasonId;
    }

    /**
     * Sets season id.
     *
     * @param seasonId the season id
     */
    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    /**
     * Gets weather id.
     *
     * @return the weather id
     */
    public int getWeatherId() {
        return weatherId;
    }

    /**
     * Sets weather id.
     *
     * @param weatherId the weather id
     */
    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }


    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewingHabit that = (ViewingHabit) o;
        return id == that.id &&
                movieId == that.movieId &&
                seasonId == that.seasonId &&
                weatherId == that.weatherId &&
                userId == that.userId &&
                Objects.equals(dateWatched, that.dateWatched);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, movieId, dateWatched, seasonId, weatherId, userId);
    }

    @Override
    public String toString() {
        return "ViewingHabit{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", dateWatched=" + dateWatched +
                ", seasonId=" + seasonId +
                ", weatherId=" + weatherId +
                ", userId=" + userId +
                '}';
    }
}
