package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "commande_produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits;

    private double total;

    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    public Commande(List<Produit> produits, double total, Date dateCommande) {
        this.id = id;
        this.produits = produits;
        this.total = total;
        this.dateCommande = dateCommande;
    }

    public Commande() {

    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", produits=" + produits +
                ", total=" + total +
                ", dateCommande=" + dateCommande +
                '}';
    }
}
