package org.example.Repository;

import org.example.Entity.ProductFood;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class BaseRepository<T> {
    protected EntityManager em;

    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public void save(T element) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(element);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(T element) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.contains(element) ? element : em.merge(element));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public T findById(Class<T> entityClass, Long id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll(Class<T> entityClass) {
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    public abstract ProductFood findById(int id);

    public abstract List<ProductFood> findAll();
}
