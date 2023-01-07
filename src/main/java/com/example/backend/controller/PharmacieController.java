package com.example.backend.controller;

import com.example.backend.beans.Pharmacie;
import com.example.backend.beans.User;
import com.example.backend.beans.Ville;
import com.example.backend.repository.PharmacieRepository;
import com.example.backend.service.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/pharmacies")
public class PharmacieController {

    @Autowired
    private PharmacieService pharmacieService;
    @Autowired
    PharmacieRepository pharmacieRepository;

    @GetMapping("/all")
    public List<Pharmacie> findAll(){
        return pharmacieRepository.findAllPharmacies();
    }

    @GetMapping(value = "/byZone/{zone}")
    public List<HashMap> findPharmacieByZone(@PathVariable(required = true) int zone) throws ParseException {

        List<HashMap> res = new ArrayList<>();
        for(Pharmacie p:pharmacieRepository.findByZone(zone)){
            HashMap re = new HashMap();
            re.put("lat",p.getLatitude());
            re.put("long",p.getLongitude());
            res.add(re);


        }
        return res;
    }

    @GetMapping(value = "/byZoneString/{zone}")
    public List<Pharmacie> findPharmacieByZoneString(@PathVariable(required = true) String zone) throws ParseException {

        return pharmacieRepository.findByZoneString(zone);

    }


    @GetMapping(value = "/byZoneVille/{zone}/{ville}")
    public List<Pharmacie> findPharmacieByZoneVille(@PathVariable(required = true) int zone, @PathVariable(required = true) int ville) throws ParseException {
        return pharmacieRepository.findByZoneVille(zone,ville);
    }


    @GetMapping(value = "/byZoneVilleString/{zone}/{ville}")
    public List<Pharmacie> findPharmacieByZoneVilleString(@PathVariable(required = true) String zone, @PathVariable(required = true) String ville) throws ParseException {
        return pharmacieRepository.findByZoneVilleString(zone,ville);
    }
    @GetMapping(value = "/byLatLong/{zone}/{ville}/{lat}/{lon}")
    public Pharmacie findMinDistance(@PathVariable(required = true) double lat, @PathVariable(required = true) double lon, @PathVariable(required = true) String zone, @PathVariable(required = true) String ville) throws ParseException {
        List<ArrayList> pharmacies =  pharmacieRepository.findMinDistance(lat,lon,zone,ville);
        List<Pharmacie> p = pharmacies.get(0);
        Pharmacie pp = p.get(0);
        return pp;

    }


    @GetMapping(value = "/byUsernameAndPasword/{username}/{password}")
    public List<Pharmacie> findPharmacieByUsernameAndPassword(@PathVariable(required = true) String username, @PathVariable(required = true) String password) throws ParseException {
        return pharmacieRepository.findByUsernameAndPassword(username,password);
    }

    @GetMapping(value = "/byPharmacien/{pharmacienId}")
    public List<Pharmacie> findPharmacienId(@PathVariable(required = true) int pharmacienId) throws ParseException {
        return pharmacieRepository.findByPharmacienId(pharmacienId);
    }

    @PostMapping("/addPharmacie")
    public String add(@RequestBody Pharmacie pharmacie){
        pharmacieService.savePharmacie(pharmacie);
        return "New pharmacie added";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        Pharmacie pharmacie = null;
        pharmacie = pharmacieService.getPharmacieById(id);
        pharmacieService.deletePharmacie(pharmacie);
        return "Pharmacie deleted successfully";

    }

    @PutMapping("/modifyPharmacie/{id}")
    public String update(@PathVariable(value = "id") int id , @RequestBody Pharmacie pharmacie){
        Pharmacie existPharmacie =  pharmacieService.getPharmacieById(id);
        existPharmacie.setNom(pharmacie.getNom());
        existPharmacie.setAdresse(pharmacie.getAdresse());
        existPharmacie.setLongitude(pharmacie.getLongitude());
        existPharmacie.setLatitude(pharmacie.getLatitude());
        existPharmacie.setZone(pharmacie.getZone());
        existPharmacie.setPharmacien(pharmacie.getPharmacien());
        pharmacieService.updatePharmacie(existPharmacie);
        return "pharmacie updated successfully";

    }


}
