package com.example.backend.beans;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PharmacieGarde {
    @EmbeddedId
    PharmacieGardeKey id;

    @ManyToOne
    @MapsId("pharmacieId")
    @JoinColumn(name = "pharmacie_id")
    Pharmacie pharmacie;

    @ManyToOne
    @MapsId("GardeId")
    @JoinColumn(name = "garde_id")
    Garde garde;


    private String dateDebut;

    private String dateFin;




    public PharmacieGardeKey getId() {
        return id;
    }

    public void setId(PharmacieGardeKey id) {
        this.id = id;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
}
