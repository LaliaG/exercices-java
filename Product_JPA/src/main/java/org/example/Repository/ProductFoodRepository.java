package org.example.Repository;

import org.example.Entity.ProductFood;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductFoodRepository extends BaseRepository<ProductFood> {
    public ProductFoodRepository(EntityManager em) {
        super(em);
    }

    @Override
    public ProductFood findById(int id) {
        return super.findById(ProductFood.class, Long.valueOf(id));
    }

    @Override
    public List<ProductFood> findAll() {
        return super.findAll(ProductFood.class);
    }
}

