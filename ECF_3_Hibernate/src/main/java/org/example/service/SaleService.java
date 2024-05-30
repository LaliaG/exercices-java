package org.example.service;

import org.example.entities.Sale;
import org.example.interfaces.Repository;

public class SaleService extends BaseService<Sale> implements Repository<Sale> {
    public SaleService() {
        super();
    }

    @Override
    public boolean create(Sale sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Sale sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Sale sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Sale findById(int id) {
        session = sessionFactory.openSession();
        Sale sale = session.get(Sale.class, id);
        session.close();
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        session = sessionFactory.openSession();
        Query<Sale> query = session.createQuery("from Sale");
        List<Sale> saleList = query.list();
        session.close();
        return saleList;
    }

    // Méthode pour générer un reçu de vente pour un client
    public Receipt generateReceipt(int saleId) {
        Sale sale = findById(saleId);
        if (sale != null) {
            Receipt receipt = new Receipt();
            // Logique pour générer le reçu
            receipt.setSale(sale);
            receipt.setTotalAmount(calculateTotalAmount(sale));
            // Autres détails du reçu
            return receipt;
        }
        return null;
    }

    // Méthode pour calculer le montant total de la vente
    private double calculateTotalAmount(Sale sale) {
        double totalAmount = 0.0;
        for (Item item : sale.getItems()) {
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }
}
