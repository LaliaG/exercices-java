package org.example.exercice6.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stock;

    public Product(String brand, String reference, LocalDate purchaseDate, double price, int stock) {
        this.brand = brand;
        this.reference = reference;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.stock = stock;
    }

    public Product() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", reference='" + reference + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
