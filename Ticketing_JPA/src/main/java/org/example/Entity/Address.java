package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Embeddable
@Setter
@Getter
@Entity
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String street;
    protected String city;



    public Address() {

    }

}
