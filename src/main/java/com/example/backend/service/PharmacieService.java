package com.example.backend.service;

import com.example.backend.beans.Pharmacie;

import java.util.List;

public interface PharmacieService {
    public List<Pharmacie> getAllPharmacies();
    public Pharmacie savePharmacie(Pharmacie pharmacie);
    public Pharmacie updatePharmacie(Pharmacie pharmacie);

    Pharmacie getPharmacieById(int id);

    void deletePharmacie(Pharmacie pharmacie);
}
