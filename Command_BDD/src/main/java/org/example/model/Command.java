package org.example.model;

import org.example.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {
    private Map<Product, Integer> products = new HashMap<>();

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            int quantity = products.get(product);
            if (quantity > 1) {
                products.put(product, quantity - 1);
            } else {
                products.remove(product);
            }
        } else {
            throw new ProductNotFoundException("Product not found in command");
        }
    }

}
