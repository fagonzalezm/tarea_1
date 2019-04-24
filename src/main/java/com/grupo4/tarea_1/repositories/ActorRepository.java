package com.grupo4.tarea_1.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.grupo4.tarea_1.models.Actor;
import com.grupo4.tarea_1.models.Film;

public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer>{
    Actor findActorByActorId(Integer actorId);
}
