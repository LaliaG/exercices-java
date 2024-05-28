package org.example.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
/*
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Address {
    protected String street;
    protected String city;
}
*/
@Entity
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String street;
    protected String city;


}



