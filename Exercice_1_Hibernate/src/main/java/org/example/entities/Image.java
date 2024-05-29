package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public Image() {
    }

    public Image(String url, Produit produit) {
        this.url = url;
        this.produit = produit;
    }

}
