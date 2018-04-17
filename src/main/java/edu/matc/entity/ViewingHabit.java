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

    @Column(name = "temp")
    private int temp;

    @Column(name = "weather_sunny")
    private boolean weatherSunny;

    @Column(name = "weather_rainy")
    private boolean weatherRainy;

    @Column(name = "weather_foggy")
    private boolean weatherFoggy;

    @Column(name = "weather_snowy")
    private boolean weatherSnowy;

    @Column(name = "weather_hail")
    private boolean weatherHail;

    @Column(name = "weather_thunder")
    private boolean weatherThunder;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Viewing habit.
     */
    public ViewingHabit() {
    }

    /**
     * Instantiates a new Viewing habit.
     *
     * @param movieId        the movie id
     * @param dateWatched    the date watched
     * @param temp           the temp
     * @param weatherSunny   the weather sunny
     * @param weatherRainy   the weather rainy
     * @param weatherFoggy   the weather foggy
     * @param weatherSnowy   the weather snowy
     * @param weatherHail    the weather hail
     * @param weatherThunder the weather thunder
     * @param user           the user
     */
    public ViewingHabit(int movieId, LocalDate dateWatched, int temp, boolean weatherSunny, boolean weatherRainy, boolean weatherFoggy, boolean weatherSnowy, boolean weatherHail, boolean weatherThunder, User user) {
        this.movieId = movieId;
        this.dateWatched = dateWatched;
        this.temp = temp;
        this.weatherSunny = weatherSunny;
        this.weatherRainy = weatherRainy;
        this.weatherFoggy = weatherFoggy;
        this.weatherSnowy = weatherSnowy;
        this.weatherHail = weatherHail;
        this.weatherThunder = weatherThunder;
        this.user = user;
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
     * Is weather sunny boolean.
     *
     * @return the boolean
     */
    public boolean isWeatherSunny() {
        return weatherSunny;
    }

    /**
     * Sets weather sunny.
     *
     * @param weatherSunny the weather sunny
     */
    public void setWeatherSunny(boolean weatherSunny) {
        this.weatherSunny = weatherSunny;
    }

    /**
     * Is weather rainy boolean.
     *
     * @return the boolean
     */
    public boolean isWeatherRainy() {
        return weatherRainy;
    }

    /**
     * Sets weather rainy.
     *
     * @param weatherRainy the weather rainy
     */
    public void setWeatherRainy(boolean weatherRainy) {
        this.weatherRainy = weatherRainy;
    }

    /**
     * Is weather foggy boolean.
     *
     * @return the boolean
     */
    public boolean isWeatherFoggy() {
        return weatherFoggy;
    }

    /**
     * Sets weather foggy.
     *
     * @param weatherFoggy the weather foggy
     */
    public void setWeatherFoggy(boolean weatherFoggy) {
        this.weatherFoggy = weatherFoggy;
    }

    /**
     * Is weather snowy boolean.
     *
     * @return the boolean
     */
    public boolean isWeatherSnowy() {
        return weatherSnowy;
    }

    /**
     * Sets weather snowy.
     *
     * @param weatherSnowy the weather snowy
     */
    public void setWeatherSnowy(boolean weatherSnowy) {
        this.weatherSnowy = weatherSnowy;
    }

    /**
     * Is weather hail boolean.
     *
     * @return the boolean
     */
    public boolean isWeatherHail() {
        return weatherHail;
    }

    /**
     * Sets weather hail.
     *
     * @param weatherHail the weather hail
     */
    public void setWeatherHail(boolean weatherHail) {
        this.weatherHail = weatherHail;
    }

    /**
     * Is weather thunder boolean.
     *
     * @return the boolean
     */
    public boolean isWeatherThunder() {
        return weatherThunder;
    }

    /**
     * Sets weather thunder.
     *
     * @param weatherThunder the weather thunder
     */
    public void setWeatherThunder(boolean weatherThunder) {
        this.weatherThunder = weatherThunder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewingHabit that = (ViewingHabit) o;
        return id == that.id &&
                movieId == that.movieId &&
                temp == that.temp &&
                weatherSunny == that.weatherSunny &&
                weatherRainy == that.weatherRainy &&
                weatherFoggy == that.weatherFoggy &&
                weatherSnowy == that.weatherSnowy &&
                weatherHail == that.weatherHail &&
                weatherThunder == that.weatherThunder &&
                Objects.equals(dateWatched, that.dateWatched) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, movieId, dateWatched, temp, weatherSunny, weatherRainy, weatherFoggy, weatherSnowy, weatherHail, weatherThunder, user);
    }

    @Override
    public String toString() {
        return "ViewingHabit{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", dateWatched=" + dateWatched +
                ", temp=" + temp +
                ", weatherSunny=" + weatherSunny +
                ", weatherRainy=" + weatherRainy +
                ", weatherFoggy=" + weatherFoggy +
                ", weatherSnowy=" + weatherSnowy +
                ", weatherHail=" + weatherHail +
                ", weatherThunder=" + weatherThunder +
                '}';
    }
}
