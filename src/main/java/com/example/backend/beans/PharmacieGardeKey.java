package com.example.backend.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PharmacieGardeKey implements Serializable {

    @Column(name = "pharmacie_id")
    int PharmacieId;

    @Column(name = "garde_id")
    int GardeId;

    public PharmacieGardeKey() {

    }

    public int getPharmacieId() {
        return PharmacieId;
    }

    public PharmacieGardeKey(int pharmacieId, int gardeId) {
        PharmacieId = pharmacieId;
        GardeId = gardeId;
    }

    public void setPharmacieId(int pharmacieId) {
        PharmacieId = pharmacieId;
    }

    public int getGardeId() {
        return GardeId;
    }

    public void setGardeId(int gardeId) {
        GardeId = gardeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacieGardeKey that = (PharmacieGardeKey) o;
        return PharmacieId == that.PharmacieId && GardeId == that.GardeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PharmacieId, GardeId);
    }
}
