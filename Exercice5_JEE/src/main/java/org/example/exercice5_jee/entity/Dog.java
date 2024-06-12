package org.example.exercice5_jee.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "dog")
public class Dog {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String breed;
    private LocalDate birthDate;

    public Dog(Long id, String name, String breed, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
    }

    public Dog() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
