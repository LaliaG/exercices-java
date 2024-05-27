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
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="device_id")
    private int id;

    private String name;
    private String description;

   @ManyToMany(mappedBy = "devices")
    private List<Computer> computers;


    public void add (Computer computer){
        computers.add(computer);
    }

}
