package org.example.service;

import org.example.entities.Sale;
import org.example.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;



public class SaleService extends BaseService implements Repository<Sale> {
    public SaleService() {
        super();
    }

    @Override
    public boolean create(Sale sale) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Sale sale) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Sale sale) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Sale findById(int id) {
        Session session = sessionFactory.openSession();
        Sale sale = session.get(Sale.class, id);
        session.close();
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        Session session = sessionFactory.openSession();
        Query<Sale> query = session.createQuery("from Sale", Sale.class);
        List<Sale> saleList = query.list();
        session.close();
        return saleList;
    }

    public List<Sale> findSalesByCustomerId(int customerId) {
        Session session = sessionFactory.openSession();
        Query<Sale> saleQuery = session.createQuery("from Sale where customer.id = :customerId", Sale.class);
        saleQuery.setParameter("customerId", customerId);
        List<Sale> saleList = saleQuery.list();
        session.close();
        return saleList;
    }

    public List<Sale> findSalesBetweenDates(Date startDate, Date endDate) throws Exception {
        if (startDate.before(endDate)) {
            Session session = sessionFactory.openSession();
            Query<Sale> saleQuery = session.createQuery("from Sale where saleDate between :startDate and :endDate", Sale.class);
            saleQuery.setParameter("startDate", startDate);
            saleQuery.setParameter("endDate", endDate);
            List<Sale> saleList = saleQuery.list();
            session.close();
            return saleList;
        }
        throw new Exception("Invalid date range");
    }

    public double getTotalSalesValueByCustomerId(int customerId) {
        Session session = sessionFactory.openSession();
        Query<Double> query = session.createQuery("select sum(totalAmount) from Sale where customer.id = :customerId", Double.class);
        query.setParameter("customerId", customerId);
        Double totalSalesValue = query.uniqueResult();
        session.close();
        return totalSalesValue != null ? totalSalesValue : 0;
    }

    public double getAverageSaleValue() {
        Session session = sessionFactory.openSession();
        Query<Double> query = session.createQuery("select avg(totalAmount) from Sale", Double.class);
        Double averageSaleValue = query.uniqueResult();
        session.close();
        return averageSaleValue != null ? averageSaleValue : 0;
    }

    public List<Sale> findSalesByProductId(int productId) {
        Session session = sessionFactory.openSession();
        Query<Sale> saleQuery = session.createQuery("select s from Sale s join s.items i where i.product.id = :productId", Sale.class);
        saleQuery.setParameter("productId", productId);
        List<Sale> saleList = saleQuery.list();
        session.close();
        return saleList;
    }

    public List<Sale> findSalesByStatus(String status) {
        Session session = sessionFactory.openSession();
        Query<Sale> saleQuery = session.createQuery("from Sale where status = :status", Sale.class);
        saleQuery.setParameter("status", status);
        List<Sale> saleList = saleQuery.list();
        session.close();
        return saleList;
    }

    public String generateReceipt(int saleId) {
        Sale sale = findById(saleId);
        if (sale == null) {
            return "Sale not found.";
        }

        StringBuilder receipt = new StringBuilder();
        receipt.append("Receipt for Sale ID: ").append(sale.getId()).append("\n");
        receipt.append("Customer: ").append(sale.getCustomer().getName()).append("\n");
        receipt.append("Date: ").append(sale.getSaleDate()).append("\n");
        receipt.append("Items:\n");

      //  sale.getItems().forEach(item -> {
        //    receipt.append(" - ").append(item.getProduct().getName())
                  //  .append(": ").append(item.getQuantity())
                   // .append(" x ").append(item.getProduct().getPrice())
                  //  .append(" = ").append(item.getQuantity() * item.getProduct().getPrice()).append("\n");
       // });

        receipt.append("Total: ").append(sale.getTotalAmount()).append("\n");
        return receipt.toString();
    }

    public void close() {
        sessionFactory.close();
    }

}
