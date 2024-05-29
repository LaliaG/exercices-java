package org.example.interfaces;

import java.util.Date;
import java.util.List;

public interface Repository<T> {

    boolean create(T o);
    boolean update(T o);
    boolean delete(T o);

    T findById(int id);

    List<T> findAll();

    List<T> findByPrixGreaterThan(double prix);

    List<T> findByDateAchatBetween(Date startDate, Date endDate);

    List<T> findByStockLessThan(int stock);

    int calculateStockValueByMarque(String marque);

    double calculateAveragePrix();

    List<T> findByMarque(String marque);

    boolean deleteByMarque(String marque);
}

