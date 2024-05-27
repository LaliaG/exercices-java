package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OperatingSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String Version;

    @OneToMany(mappedBy = "operatingSystem")
    private List<Computer> computers;

    @Override
    public String toString() {
        return "OperatingSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Version='" + Version + '\'' +
                ", computers=" + computers +
                '}';
    }
}
