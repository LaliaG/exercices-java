package org.example.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Embeddable
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Identifiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identifiant")
    private int id;
    private String macAddress;
    private String ipAddress;

    @OneToOne(mappedBy = "identifiant, fetch = FetchType.LAZY")
    private Computer computer;

    @Override
    public String toString() {
        return "Identifiant{" +
                "id=" + id +
                ", macAddress='" + macAddress + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                //", computer=" + computer +  à supprimmer pour éviter une boucle infinie
                '}';
    }
}
