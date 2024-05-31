package org.example.service;

import org.example.entities.Item;
import org.example.entities.Sale;
import org.example.enums.Category;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReportService extends BaseService {
    private SaleService saleService;
    private ItemService itemService;

    public ReportService(SaleService saleService, ItemService itemService) {
        this.saleService = saleService;
        this.itemService = itemService;
    }

    public ReportService() {

    }

    // 1. Générer le rapport des ventes par catégorie
    public void generateCategorySalesReport() {
        List<Sale> sales = saleService.findAll();
        Map<String, Double> salesByCategory = sales.stream()
                .flatMap(sale -> sale.getItems().stream())
                .collect(Collectors.groupingBy(
                        item -> item.getCategory().toString(),
                        Collectors.summingDouble(item -> item.getPrice() * item.getStockQuantity())
                ));

        System.out.println("Sales by Category Report:");
        salesByCategory.forEach((category, totalSales) ->
                System.out.println("Category: " + category + ", Total Sales: " + totalSales));
    }


    // 2. Générer le rapport des ventes sur une période donnée
    public void generatePeriodSalesReport(Date startDate, Date endDate) {
        try {
            List<Sale> sales = saleService.findSalesBetweenDates(startDate, endDate);
            double totalSales = sales.stream()
                    .mapToDouble(Sale::getTotalAmount)
                    .sum();

            System.out.println("Sales Report for period " + startDate + " to " + endDate + ":");
            System.out.println("Total Sales: " + totalSales);
        } catch (Exception e) {
            System.err.println("Error generating period sales report: " + e.getMessage());
        }
    }

    // 3. Générer le rapport des ventes pour un client donné
    public void generateCustomerSalesReport(int customerId) {
        List<Sale> sales = saleService.findSalesByCustomerId(customerId);
        double totalSales = sales.stream()
                .mapToDouble(Sale::getTotalAmount)
                .sum();

        System.out.println("Sales Report for Customer ID " + customerId + ":");
        System.out.println("Total Sales: " + totalSales);
    }

    // 4. Générer le rapport des stocks disponibles
    public void generateStockReport() {
        List<Item> products = itemService.findAll();
        System.out.println("Stock Report:");
        products.forEach(product ->
                System.out.println("Product: " + product.getDescription() + ", Stock: " + product.getStockQuantity()));
    }

    // 5. Générer le rapport des performances des produits
    public void generateProductPerformanceReport() {
        List<Sale> sales = saleService.findAll();
        Map<String, Long> productSalesCount = sales.stream()
                .flatMap(sale -> sale.getItems().stream())
                .collect(Collectors.groupingBy(
                        item -> item.getDescription(),
                        Collectors.summingLong(Item::getStockQuantity)
                ));

        System.out.println("Product Performance Report:");
        productSalesCount.forEach((product, count) ->
                System.out.println("Product: " + product + ", Units Sold: " + count));
    }

}
