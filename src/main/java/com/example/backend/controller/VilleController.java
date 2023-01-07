package com.example.backend.controller;

import com.example.backend.beans.Ville;
import com.example.backend.repository.VilleRepository;
import com.example.backend.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/ville")
public class VilleController {

    @Autowired
    VilleRepository villeRepository;
    @Autowired
    private VilleService villeService;


    @GetMapping("/all")
    public Collection<?> findAll(){
        return villeRepository.findAll();
    }

    @PostMapping("/addVille")
    public String add(@RequestBody Ville ville){
        villeRepository.save(ville);
        return "New ville added";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        Ville ville = null;
        ville = villeService.getVilleById(id);
        villeService.deleteVille(ville);
        return "Ville deleted successfully";

    }

    @GetMapping("/allVilles")
    public List<String> findAllZones(){
        return villeRepository.findAllVilles();
    }

    @PutMapping("/modifyVille/{id}")
    public String update(@PathVariable(value = "id") int id , @RequestBody Ville ville){
        Ville existville= villeService.getVilleById(id);
        existville.setNom(ville.getNom());
        villeService.updateVille(existville);
        return "ville updated successfully";

    }




}
