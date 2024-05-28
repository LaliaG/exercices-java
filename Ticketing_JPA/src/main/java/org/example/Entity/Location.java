package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Location extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int capacity;


    @Override
    public String toString() {
        return "Location{" +
                "capacity=" + capacity +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
