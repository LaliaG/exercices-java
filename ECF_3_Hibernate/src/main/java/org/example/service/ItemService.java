package org.example.service;

import org.example.entities.Item;
import org.example.enums.Category;
import org.example.enums.Size;
import org.example.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ItemService extends BaseService implements Repository<Item> {
    public ItemService() {
        super();
    }

    @Override
    public boolean create(Item item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Item item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Item findById(int id) {
        Session session = sessionFactory.openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
    }

    @Override
    public List<Item> findAll() {
        Session session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("from Item", Item.class);
        List<Item> itemList = query.list();
        session.close();
        return itemList;
    }

    // Méthode pour filtrer les articles par catégorie
    public List<Item> filterByCategory(Category category) {
        Session session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("from Item where category = :category", Item.class);
        query.setParameter("category", category);
        List<Item> itemList = query.list();
        session.close();
        return itemList;
    }

    // Méthode pour filtrer les articles par taille
    public List<Item> filterBySize(Size size) {
        Session session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("from Item where size =  :size", Item.class);
        query.setParameter("size", size);
        List<Item> itemList = query.list();
        session.close();
        return itemList;
    }

    public void close() {
    }

    public void create(String pantalon, Category category, Size size, double v, int i) {
    }
}

