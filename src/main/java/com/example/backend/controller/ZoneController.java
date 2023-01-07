package com.example.backend.controller;

import com.example.backend.beans.Pharmacie;
import com.example.backend.beans.Ville;
import com.example.backend.beans.Zone;
import com.example.backend.repository.PharmacieRepository;
import com.example.backend.repository.ZoneRepository;
import com.example.backend.service.PharmacienService;
import com.example.backend.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/zones")
@CrossOrigin("http://localhost:3000")
public class ZoneController {
    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    ZoneService zoneService;
    @GetMapping("/all")
    public List<Zone> findAll(){
        return zoneRepository.findAll();
    }

    @GetMapping("/allZones/{ville}")
    public List<String> findAllZones(@PathVariable(value = "ville") String ville){
        return zoneRepository.findAllZones(ville);
    }

    @PostMapping("/addZone")
    public String add(@RequestBody Zone zone){
        zoneService.saveZone(zone);
        return "New zone added";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        Zone zone = null;
        zone = zoneService.getZoneById(id);
        zoneService.deleteZone(zone);
        return "Zone deleted successfully";
    }

    @PutMapping("/modifyZone/{id}")
    public String update(@PathVariable(value = "id") int id , @RequestBody Zone zone){
        Zone existZone= zoneService.getZoneById(id);
        existZone.setNom(zone.getNom());
        existZone.setVille(zone.getVille());
        zoneService.updateZone(existZone);
        return "Zone updated successfully";

    }


}
