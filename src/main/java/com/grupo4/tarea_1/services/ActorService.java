package com.grupo4.tarea_1.services;

import com.grupo4.tarea_1.models.Film;
import com.grupo4.tarea_1.models.Actor;
import com.grupo4.tarea_1.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.sql.Timestamp;

@RestController
@RequestMapping("/actors")
@CrossOrigin(origins = "*")
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Actor> getAllUsers() {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Actor findOne(@PathVariable("id") Integer id) {
        return actorRepository.findActorByActorId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Actor create(@RequestBody Actor resource) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        resource.setLastUpdate(time);
        System.out.println(resource.getLastUpdate());
        return actorRepository.save(resource);
    }

    @RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
    @ResponseBody
    public  List<Film> findFilm(@PathVariable("id") Integer id) {
        Actor actor = actorRepository.findActorByActorId(id);
        List<Film> films = actor.getFilms();
        return films;

    }

}
