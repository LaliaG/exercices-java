package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Sale> purchaseHistory;


    public Customer() {
    }

    public Customer(int id, String name, String email, List<Sale> purchaseHistory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.purchaseHistory = purchaseHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Sale> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Sale> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sales=" + purchaseHistory +
                '}';
    }
}
