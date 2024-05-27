package org.example.Entity;

import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class Enclosure {
    private int id;
    private String name;
    private List<Animal> animals;
}
