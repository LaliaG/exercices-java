package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
public class ProductElectronic extends Product{
    private int batteryDuration;

    public ProductElectronic() {
        super();
    }
}
