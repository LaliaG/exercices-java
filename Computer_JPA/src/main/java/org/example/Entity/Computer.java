package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Entity;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

//      @Embedded
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_identifiant")
    private Identifiant identifiant;

    @ManyToOne
    @JoinColumn(name = "id_processor")
    private Processor processor;


    @ManyToOne
    @JoinColumn(name = "os_id")
    private OperatingSystem opretingSystem;

    //@ManyToMany(mappedBy = "computers")
   // private List<Device> devices ;

    @ManyToMany
    @JoinTable(name = "computer_device", joinColumns = @JoinColumn(name = "computer_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private List<Device> devices;
}
