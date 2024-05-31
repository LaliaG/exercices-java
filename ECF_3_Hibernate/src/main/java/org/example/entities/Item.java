package org.example.entities;

import lombok.*;
import org.example.enums.Category;
import org.example.enums.Size;

import javax.persistence.*;
import java.util.List;
import java.util.regex.PatternSyntaxException;

@Entity
@Table(name = "Item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @Setter
    @Getter
    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Sale> sales;

    public Item(int i, String s, double v, int i1) {
    }

    public Item(int id, String description, Category catégorie, Size taille, double prix, int quantitéStock) {
    }

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


   // public String getName() {
   //     return items;
   // }

   // public void setName(String s) {
  //  }
}
