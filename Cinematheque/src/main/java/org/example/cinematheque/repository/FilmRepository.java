package org.example.cinematheque.repository;

import org.example.cinematheque.entity.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findByDirectorId(Long directorId);
}
