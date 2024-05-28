package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int idCustomer;
    private String lastname;
    private String firstname;
    private int age;
    private String phone;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    //@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
   // private List<Ticket> tickets;


    //@Embedded
    //private Address address;


}
