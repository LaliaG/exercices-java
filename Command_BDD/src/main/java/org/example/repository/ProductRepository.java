package org.example.repository;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void save(Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByCategory(String category) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
