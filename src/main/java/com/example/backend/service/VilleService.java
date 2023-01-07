package com.example.backend.service;

import com.example.backend.beans.Ville;
import com.example.backend.beans.Zone;

public interface VilleService {

    public Ville saveVille(Ville ville);
    public Ville updateVille(Ville ville);
    Ville getVilleById(int id);

    void deleteVille(Ville ville);

}
