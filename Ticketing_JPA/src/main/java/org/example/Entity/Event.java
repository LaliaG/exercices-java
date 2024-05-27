package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEvent;
    private String name;
    private LocalDate date;
    private LocalTime hour;
    private int nbOfSeats;

    @Embedded
    private Location location;
    //@OneToOne(cascade = CascadeType.ALL) 2e façon d'écrire
    //    @OneToOne
//    @JoinColumn(name="id_pot")
//    private Pot pot; 3e fçacon d'écrire le @Embedded

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name = "event_customer",joinColumns = @JoinColumn(name = "idAccount"),
            inverseJoinColumns = @JoinColumn(name = "idCustomer"))
    private List<Customer> customers;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    //@OneToMany
   // @JoinColumn(name = "idTicket")
   // private List<Ticket> tickets; 2 FACON D4ECRIRE LE ONETOMANY


}
