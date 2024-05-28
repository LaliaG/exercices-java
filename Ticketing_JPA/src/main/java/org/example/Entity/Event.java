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
    @Column (name = "id_event")
    private int idEvent;
    private String name;
    private LocalDate date;
    private LocalTime hour;

    @OneToOne
    @JoinColumn(name = "id_location")
    private Location location;

   // @Embedded
    //private Location location; 2e façon d'écrire
    //@OneToOne(cascade = CascadeType.ALL) 3e façon d'écrire

    private int nbOfSeats;

    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;
















}
