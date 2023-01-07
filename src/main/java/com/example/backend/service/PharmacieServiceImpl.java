package com.example.backend.service;

import com.example.backend.beans.Pharmacie;
import com.example.backend.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PharmacieServiceImpl implements PharmacieService{
    @Autowired
    PharmacieRepository pharmacieRepository;
    @Override
    public List<Pharmacie> getAllPharmacies() {
        return pharmacieRepository.findAll();
    }

    @Override
    public Pharmacie savePharmacie(Pharmacie pharmacie) {
        pharmacie.setId(getMaxId());
        return pharmacieRepository.save(pharmacie);
    }

    @Override
    public Pharmacie updatePharmacie(Pharmacie pharmacie) {
        return pharmacieRepository.save(pharmacie);
    }

    @Override
    public Pharmacie getPharmacieById(int id) {
        return pharmacieRepository.findById(id);
    }

    public int getMaxId() {
        return pharmacieRepository.findAll().size()+1;
    }

    public void deletePharmacie(Pharmacie pharmacie) {
        pharmacieRepository.delete(pharmacie);}
}
