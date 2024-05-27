package org.example.Repository;

import org.example.Entity.Customer;
import org.example.Entity.Ticket;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketRepository extends BaseRepository<Ticket>{
    public TicketRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Ticket findById(int id) {
        return em.find(Ticket.class,id);
    }

    @Override
    public List<Ticket> findALl() {
        return em.createQuery("select t from Ticket t").getResultList();

    }
}
