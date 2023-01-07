package com.example.backend.service;

import com.example.backend.beans.Ville;
import com.example.backend.beans.Zone;
import com.example.backend.repository.VilleRepository;
import com.example.backend.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleServiceImpl implements VilleService{
    @Autowired
    VilleRepository villeRepository;
    @Override
    public Ville getVilleById(int id) {
        return villeRepository.findById(id);
    }

    @Override
    public void deleteVille(Ville ville) {
        villeRepository.delete(ville);
    }
    public int getMaxId() {
        return villeRepository.findAll().size()+1;
    }

    @Override
    public Ville saveVille(Ville ville) {
        ville.setId(getMaxId());
        return villeRepository.save(ville);
    }

    @Override
    public Ville updateVille(Ville ville) {
        return villeRepository.save(ville);
    }
}
