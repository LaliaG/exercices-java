package org.example.exercice5_jee.model;

import java.time.LocalDate;

public class DogModel {
    private Long id;
    private String name;
    private String breed;
    private LocalDate birthDate;

    public DogModel(Long id, String name, String breed, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "DogModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
