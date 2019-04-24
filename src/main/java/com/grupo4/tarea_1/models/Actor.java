package com.grupo4.tarea_1.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import com.grupo4.tarea_1.models.Film;

@Entity
@Table(name="actor")
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actor_id", unique=true, nullable=false)
    private int actorId;

    @Column(name="first_name", nullable=false, length=45)
    private String firstName;

    @Column(name="last_name", nullable=false, length=45)
    private String lastName;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    @ManyToMany
    @JoinTable(name="film_actor", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films;

    public Actor() {
    }

    public int getActorId() {
        return this.actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
