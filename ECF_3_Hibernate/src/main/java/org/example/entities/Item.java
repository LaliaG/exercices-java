package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Category;
import org.example.enums.Size;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Sale> sales;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", size=" + size +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", sales=" + sales +
                '}';
    }
}
