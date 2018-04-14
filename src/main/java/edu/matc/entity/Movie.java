package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

/**
 * The type Movie.
 */
@Entity(name = "Movie")
@Table(name = "movie")  // The @Table tag is case sensitive REMEMBER THAT!!!  Example: ="user"  vs  "=User"
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "poster_uri")
    private String posterUri;

    @Column(name = "thumb_uri")
    private String thumbUri;

    @Column(name = "desc_uri")
    private String descUri;

    @Column(name = "rating_uri")
    private String ratingUri;

    @Column(name = "user_rating")
    private int userRating;

    @Column(name = "sort_key")
    private String sortKey;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "tmdb_id")
    private int tmdbId;

    @ManyToOne
    private User user;


    /**
     * Instantiates a new Movie.
     */
    public Movie() {
    }

    /**
     * Instantiates a new Movie.
     *
     * @param name       the name
     * @param posterUri  the poster uri
     * @param thumbUri   the thumb uri
     * @param descUri    the desc uri
     * @param ratingUri  the rating uri
     * @param userRating the user rating
     * @param sortKey    the sort key
     * @param loginId    the login id
     * @param user       the user
     */
    public Movie(String name, String posterUri, String thumbUri, String descUri,
                 String ratingUri, int userRating, String sortKey, String loginId,
                 User user) {
        this.name = name;
        this.posterUri = posterUri;
        this.thumbUri = thumbUri;
        this.descUri = descUri;
        this.ratingUri = ratingUri;
        this.userRating = userRating;
        this.sortKey = sortKey;
        this.loginId = loginId;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets poster uri.
     *
     * @return the poster uri
     */
    public String getPosterUri() {
        return posterUri;
    }

    /**
     * Sets poster uri.
     *
     * @param posterUri the poster uri
     */
    public void setPosterUri(String posterUri) {
        this.posterUri = posterUri;
    }

    /**
     * Gets thumb uri.
     *
     * @return the thumb uri
     */
    public String getThumbUri() {
        return thumbUri;
    }

    /**
     * Sets thumb uri.
     *
     * @param thumbUri the thumb uri
     */
    public void setThumbUri(String thumbUri) {
        this.thumbUri = thumbUri;
    }

    /**
     * Gets desc uri.
     *
     * @return the desc uri
     */
    public String getDescUri() {
        return descUri;
    }

    /**
     * Sets desc uri.
     *
     * @param descUri the desc uri
     */
    public void setDescUri(String descUri) {
        this.descUri = descUri;
    }

    /**
     * Gets rating uri.
     *
     * @return the rating uri
     */
    public String getRatingUri() {
        return ratingUri;
    }

    /**
     * Sets rating uri.
     *
     * @param ratingUri the rating uri
     */
    public void setRatingUri(String ratingUri) {
        this.ratingUri = ratingUri;
    }

    /**
     * Gets user rating.
     *
     * @return the user rating
     */
    public int getUserRating() {
        return userRating;
    }

    /**
     * Sets user rating.
     *
     * @param userRating the user rating
     */
    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    /**
     * Gets sort key.
     *
     * @return the sort key
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * Sets sort key.
     *
     * @param sortKey the sort key
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
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
     * Gets login id.
     *
     * @return the login id
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets login id.
     *
     * @param loginId the login id
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets tmdb id.
     *
     * @return the tmdb id
     */
    public int getTmdbId() {
        return tmdbId;
    }

    /**
     * Sets tmdb id.
     *
     * @param tmdbId the tmdb id
     */
    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posterUri='" + posterUri + '\'' +
                ", thumbUri='" + thumbUri + '\'' +
                ", descUri='" + descUri + '\'' +
                ", ratingUri='" + ratingUri + '\'' +
                ", userRating=" + userRating +
                ", sortKey='" + sortKey + '\'' +
                ", loginId='" + loginId + '\'' +
                ", tmdbId=" + tmdbId +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                userRating == movie.userRating &&
                tmdbId == movie.tmdbId &&
                Objects.equals(name, movie.name) &&
                Objects.equals(posterUri, movie.posterUri) &&
                Objects.equals(thumbUri, movie.thumbUri) &&
                Objects.equals(descUri, movie.descUri) &&
                Objects.equals(ratingUri, movie.ratingUri) &&
                Objects.equals(sortKey, movie.sortKey) &&
                Objects.equals(loginId, movie.loginId) &&
                Objects.equals(user, movie.user);
    }


    @Override
    public int hashCode() {

        return Objects.hash(id, name, posterUri, thumbUri, descUri, ratingUri, userRating, sortKey, loginId, tmdbId, user);
    }
}
