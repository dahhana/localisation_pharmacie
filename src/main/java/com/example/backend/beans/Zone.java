package com.example.backend.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "zone", fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private Set<Pharmacie> pharmacies;


    @ManyToOne(optional = true)
    @JoinColumn(name = "ville_id")
    private Ville ville;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonIgnore
    public Set<Pharmacie> getPharmacies() {
        return pharmacies;
    }
    @JsonSetter
    public void setPharmacies(Set<Pharmacie> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

}
