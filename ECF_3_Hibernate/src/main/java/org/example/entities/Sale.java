package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.SaleStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sale")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SaleStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "sale_items",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    public Sale(Date date, SaleStatus saleStatus, Customer byId) {
    }

    public Sale(int id, Date date, int i, int i1, int i2) {
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }

    public void addItem(Item byId) {
    }

    public void setQuantity(int i) {
    }

    public double getTotalAmount() {
        return 0;
    }

    public char[] getSaleDate() {
        return new char[0];
    }
}
