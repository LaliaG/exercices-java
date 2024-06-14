package org.example.exercice6_jee.repository;

import java.util.List;

public interface Repository<T> {
    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    boolean delete(int id);

    T findById(int id);

    List<T> findAll();

}
