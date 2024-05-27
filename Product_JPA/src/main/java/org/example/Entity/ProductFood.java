package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Builder
public class ProductFood extends  Product{
    private LocalDate expiryDate;

    public ProductFood() {
        super();
    }
}
