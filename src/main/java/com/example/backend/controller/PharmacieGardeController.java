package com.example.backend.controller;

import com.example.backend.beans.Pharmacie;
import com.example.backend.beans.PharmacieGarde;
import com.example.backend.repository.PharmacieGardeRepository;
import com.example.backend.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pharmacieGarde")
public class PharmacieGardeController {
    @Autowired
    PharmacieGardeRepository pharmacieGardeRepository;

    @PostMapping("/addPharmacieGarde")
    public String add(@RequestBody PharmacieGarde pharmacieGarde){
        pharmacieGardeRepository.save(pharmacieGarde);
        return "New pharmacie en garde";
    }

    @RequestMapping(value = "/{ph_id}/{garde_id}/{dateDebut}/{dateFin}", method=RequestMethod.POST)
    public void addPharmacie(@PathVariable(required = true) String ph_id, @PathVariable(required = true) String garde_id, @PathVariable(required = true) String dateDebut, @PathVariable(required = true) String dateFin) throws ParseException {
        pharmacieGardeRepository.inserPharmacieGarde(Integer.parseInt(garde_id), Integer.parseInt(ph_id), dateDebut, dateFin);

    }
    @GetMapping(value ="/all" )
    public List<PharmacieGarde> getAll(){
        return pharmacieGardeRepository.findAll();
    }

    @GetMapping(value = "/gardeNuitbyZoneVille/{zone}/{ville}")
    public List<Pharmacie> getPharmacieGardeNuit(@PathVariable(required = true) String zone, @PathVariable(required = true) String ville) throws ParseException {
        return pharmacieGardeRepository.getPharmacieGardeNuit(zone,ville);
    }

    @GetMapping(value = "/gardeJourbyZoneVille/{zone}/{ville}")
    public List<Pharmacie> getPharmacieGardeJour(@PathVariable(required = true) String zone, @PathVariable(required = true) String ville) throws ParseException {
        return pharmacieGardeRepository.getPharmacieGardeJour(zone,ville);
    }

    @GetMapping(value = "/byLatLongJour/{zone}/{ville}/{lat}/{lon}")
    public Pharmacie findMinDistanceJour(@PathVariable(required = true) double lat, @PathVariable(required = true) double lon, @PathVariable(required = true) String zone, @PathVariable(required = true) String ville) throws ParseException {
        List<ArrayList> pharmacies =  pharmacieGardeRepository.findMinDistanceJour(lat,lon,zone,ville);
        List<Pharmacie> p = pharmacies.get(0);
        Pharmacie pp = p.get(0);
        return pp;

    }

    @GetMapping(value = "/byLatLongNuit/{zone}/{ville}/{lat}/{lon}")
    public Pharmacie findMinDistanceNight(@PathVariable(required = true) double lat, @PathVariable(required = true) double lon, @PathVariable(required = true) String zone, @PathVariable(required = true) String ville) throws ParseException {
        List<ArrayList> pharmacies = pharmacieGardeRepository.findMinDistanceNuit(lat, lon, zone, ville);
        List<Pharmacie> p = pharmacies.get(0);
        Pharmacie pp = p.get(0);
        return pp;
    }



    }
