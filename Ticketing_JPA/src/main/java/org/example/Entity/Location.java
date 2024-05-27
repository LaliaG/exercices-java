package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Embeddable
@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Location extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int capacity;

    @Embedded
    private Address address;

    public Location() {
        super();
    }
    //    @OneToOne(mappedBy = "location")
//    private Event event; 2e facon d'écrire @Embeddable

}
