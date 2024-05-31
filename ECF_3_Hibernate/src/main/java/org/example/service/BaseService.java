package org.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class BaseService {
    protected

    StandardServiceRegistry registre;

    protected SessionFactory sessionFactory;

    protected Session session;

    public BaseService(){
        registre = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
    }
}