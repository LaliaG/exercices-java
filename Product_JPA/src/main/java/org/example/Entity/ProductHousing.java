package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
public class ProductHousing extends Product {
    private double height;
    private double width;

    public ProductHousing() {
        super();
    }
}
