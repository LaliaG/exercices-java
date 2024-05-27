package org.example.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepository<T>{
    protected EntityManager em;

    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public void save (T element){
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    };
    public void delete (T element){
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }
    public abstract T findById (int id);
    public abstract List<T> findALl ();

}
