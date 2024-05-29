package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String contenu;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int note;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public Commentaire() {
    }

    public Commentaire(String contenu, Date date, int note, Produit produit) {
        this.contenu = contenu;
        this.date = date;
        this.note = note;
        this.produit = produit;
    }

}
