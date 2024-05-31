package org.example.interfaces;

import java.util.List;

public interface Repository<T> {
    boolean create(T entity);
    boolean update(T entity);
    boolean delete(T entity);
    T findById(int id);
    List<T> findAll();
}
