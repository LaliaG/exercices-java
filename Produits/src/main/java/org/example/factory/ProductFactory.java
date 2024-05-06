package org.example.factory;

import org.example.entity.AbstractProductBuilder;
import org.example.entity.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(AbstractProductBuilder builder);

    public <ProductBuilder> ProductBuilder createBuilder() {
    }
}

