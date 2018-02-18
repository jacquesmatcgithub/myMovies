package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent a user.
 *
 * @author Jacques Fourie
 */
@Entity(name = "MetadataTmdb")
@Table(name = "metadata_tmdb")  // The @Table tag is case sensitive REMEMBER THAT!!!  Example: ="user"  vs  "=User"
public class MetadataTmdb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "logo_size")
    private String logoSize;

    @Column(name = "backdrop_size")
    private String backdropSize;

    public MetadataTmdb() {
    }

    /**
     * Instantiates a new Metadata tmdb.
     *
     * @param baseUrl      the base url
     * @param logoSize     the logo size
     * @param backdropSize the backdrop size
     */
    public MetadataTmdb(String baseUrl, String logoSize, String backdropSize) {
        this.baseUrl = baseUrl;
        this.logoSize = logoSize;
        this.backdropSize = backdropSize;
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
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets base url.
     *
     * @param baseUrl the base url
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Gets logo size.
     *
     * @return the logo size
     */
    public String getLogoSize() {
        return logoSize;
    }

    /**
     * Sets logo size.
     *
     * @param logoSize the logo size
     */
    public void setLogoSize(String logoSize) {
        this.logoSize = logoSize;
    }

    /**
     * Gets backdrop size.
     *
     * @return the backdrop size
     */
    public String getBackdropSize() {
        return backdropSize;
    }

    /**
     * Sets backdrop size.
     *
     * @param backdropSize the backdrop size
     */
    public void setBackdropSize(String backdropSize) {
        this.backdropSize = backdropSize;
    }


    @Override
    public String toString() {
        return "MetadataTmdb{" +
                "id=" + id +
                ", baseUrl='" + baseUrl + '\'' +
                ", logoSize='" + logoSize + '\'' +
                ", backdropSize='" + backdropSize + '\'' +
                '}';
    }
}