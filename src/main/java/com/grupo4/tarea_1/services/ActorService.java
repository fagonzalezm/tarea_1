package com.grupo4.tarea_1.services;

import com.grupo4.tarea_1.models.Actor;
import com.grupo4.tarea_1.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return actorRepository.save(resource);
    }
}
