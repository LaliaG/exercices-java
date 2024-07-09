package org.example.cinematheque.repository;

import org.example.cinematheque.entity.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
