package com.grupo4.tarea_1.repositories;

import com.grupo4.tarea_1.models.Actor;
import com.grupo4.tarea_1.models.Film;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {
    Film findFilmByFilmId(Integer actorId);
}
