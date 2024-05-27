package org.example.Repository;

import org.example.Entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepository extends BaseRepository<Customer>{
    public CustomerRepository(EntityManager em) {
        super(em);
    }
    @Override
    public Customer findById(int id) {
        return em.find(Customer.class,id);
    }

    @Override
    public List<Customer> findALl() {
        return em.createQuery("select c from Customer c").getResultList();
    }
}
