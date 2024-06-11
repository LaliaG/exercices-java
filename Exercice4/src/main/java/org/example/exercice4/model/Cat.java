package org.example.exercice4.model;

public class Cat {
    private String name;
    private String race;
    private String favouriteMeal;
    private String dateOfBirth;

    public Cat(String name, String race, String favouriteMeal, String dateOfBirth) {
        this.name = name;
        this.race = race;
        this.favouriteMeal = favouriteMeal;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getFavouriteMeal() {
        return favouriteMeal;
    }

    public void setFavouriteMeal(String favouriteMeal) {
        this.favouriteMeal = favouriteMeal;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", favouriteMeal='" + favouriteMeal + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
