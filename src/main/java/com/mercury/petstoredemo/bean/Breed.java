package com.mercury.petstoredemo.bean;

import javax.persistence.*;

@Entity
@Table(name = "Project_Breed")
public class Breed {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String BreedName;

    @Column
    private String species;

    public Breed() {
    }

    public Breed(int id, String breedName, String species) {
        this.id = id;
        BreedName = breedName;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreedName() {
        return BreedName;
    }

    public void setBreedName(String breedName) {
        BreedName = breedName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", BreedName='" + BreedName + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
