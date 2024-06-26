package org.example.exercice6_jee.repository;

import org.example.exercice6_jee.model.User;

import java.util.List;

public interface Repository<T> {
    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    boolean delete(int id);

    T findById(int id);

   // User findById(int id);deux déclarations de méthode findById avec des types de retour différents (User et T), ce qui peut provoquer des conflits de type.

    List<T> findAll();

}
