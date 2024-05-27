package org.example.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.TypeOfSeats;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTicket;

    @NotNull
    private int nbTicket;
    private TypeOfSeats typeOfSeats;

    @ManyToOne(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name  = "idEvent")
    private Event event;

    //@ManyToOne
   // @JoinColumn(name = "id_fleuriste")
   // private Fleuriste fleuriste; 2 FA9ON D42CRIRE MANYTOONE

    //@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
   // @JoinColumn(name  = "idEvent")
    //private Event event;


}
