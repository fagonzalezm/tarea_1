package com.grupo4.tarea_1.services;

import com.grupo4.tarea_1.models.Film;
import com.grupo4.tarea_1.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
@CrossOrigin(origins = "http://localhost:8082")
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Film> getAllUsers() {
        return filmRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Film findOne(@PathVariable("id") Integer id) { return filmRepository.findFilmByFilmId(id); }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Film create(@RequestBody Film resource) {
        return filmRepository.save(resource);
    }
}
