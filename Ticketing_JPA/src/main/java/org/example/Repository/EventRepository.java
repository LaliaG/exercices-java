package org.example.Repository;

import org.example.Entity.Customer;
import org.example.Entity.Event;

import javax.persistence.EntityManager;
import java.util.List;

public class EventRepository extends BaseRepository<Event>{
    public EventRepository(EntityManager em) {
        super(em);
    }
    @Override
    public Event findById(int id) {
        return em.find(Event.class,id);
    }

    @Override
    public List<Event> findALl() {
        return em.createQuery("select e from Event e").getResultList();
    }
}
