package org.example.interfaces;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(int id);
    List<T> findAll();
}
