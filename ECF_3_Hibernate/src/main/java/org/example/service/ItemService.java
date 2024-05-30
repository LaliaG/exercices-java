package org.example.service;

import org.example.entities.Item;
import org.example.enums.Category;
import org.example.enums.Size;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ItemService extends BaseService<Item> implements Repository<Item> {
    public ItemService() {
        super();
    }

    @Override
    public boolean create(Item item) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item item) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Item item) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Item findById(int id) {
        session = sessionFactory.openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
    }

    @Override
    public List<Item> findAll() {
        session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("from Item");
        List<Item> itemList = query.list();
        session.close();
        return itemList;
    }

    // Méthode pour filtrer les articles par catégorie
    public List<Item> filterByCategory(Category category) {
        session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("from Item where category = :category");
        query.setParameter("category", category);
        List<Item> itemList = query.list();
        session.close();
        return itemList;
    }

    // Méthode pour filtrer les articles par taille
    public List<Item> filterBySize(Size size) {
        session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("from Item where size = :size");
        query.setParameter("size", size);
        List<Item> itemList = query.list();
        session.close();
        return itemList;
    }
}
