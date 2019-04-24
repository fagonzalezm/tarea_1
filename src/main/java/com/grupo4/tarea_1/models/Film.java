package com.grupo4.tarea_1.models;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT a FROM Film a")
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="film_id", unique=true, nullable=false)
    private int filmId;

    @Column(name="title", nullable=false, length=45)
    private String title;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="release_year", nullable=false, length=5)
    private Integer releaseYear;

    @Column(name="rental_duration", nullable=false, length=45)
    private Integer rentalDuration;

    @Column(name="rental_rate", nullable=false, length=45)
    private float rentalRate;

    @Column(name="length", nullable=false, length=45)
    private Integer length;

    @Column(name="replacement_cost", nullable=false, length=45)
    private float replacementCost;

    @Column(name="rating", nullable=false, length=10)
    private String Rating;

    @Column(name="special_features", nullable=false, length=45)
    private String specialFeatures;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    @JsonIgnore
    @ManyToMany(mappedBy = "films")
    private List<Actor> actors;

    public Film(){
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

}
