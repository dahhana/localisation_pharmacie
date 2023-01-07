package com.example.backend.controller;

import com.example.backend.beans.User;
import com.example.backend.repository.PharmacienRepository;
import com.example.backend.service.PharmacienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

@RestController
@RequestMapping("/pharmacien")
public class PharmacienController {

    @Autowired
    PharmacienRepository pharmacienRepository;

    @Autowired
    PharmacienService pharmacienService;
    @GetMapping("/all")
    public Collection<?> findAll(){
        return pharmacienRepository.findAll();
    }

    @PostMapping("/addPharmacien")
    public String add(@RequestBody User pharmacien){
        pharmacienService.savePharmacien(pharmacien);
        return "New pharmacien added";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        User pharmacien = null;
        pharmacien = pharmacienService.getPharmacienById(id);
        pharmacienService.deletePharmacien(pharmacien);
        return "Pharmacien deleted successfully";

    }

    @PutMapping("/modifyPharmacien/{id}")
    public String update(@PathVariable(value = "id") int id , @RequestBody User pharmacien){
        User existPharmacien= pharmacienService.getPharmacienById(id);
        existPharmacien.setNom(pharmacien.getNom());
        existPharmacien.setEmail(pharmacien.getEmail());
        existPharmacien.setPrenom(pharmacien.getPrenom());
        existPharmacien.setPassword(pharmacien.getPassword());
        existPharmacien.setUsername(pharmacien.getUsername());
        pharmacienService.updatePharmacien(existPharmacien);
        return "pharmacien updated successfully";

    }
    @GetMapping("/getPharmacien/{user_id}")
    public User findPharmacienById(@PathVariable(required = true) int user_id) throws ParseException {
        return pharmacienRepository.findPharmacienById(user_id);
    }

    @GetMapping("/login/{username}/{password}")
    public String loginPharmacien(@PathVariable(required = true) String username, @PathVariable(required = true) String password) throws ParseException {
        User u = pharmacienRepository.loginPharmacien(username);
        String pwd =  u.getPassword();
        if(pwd.equals(password)){
            if(u.getRole().equals("pharmacien")){
                return "success";
            }else{
                return "vous navez pas le droit d'acces";
            }
        }else
            return "login ou mot de passe incorrect";

    }

    @GetMapping("/loginAdmin/{username}/{password}")
    public String loginAdminPharmacien(@PathVariable(required = true) String username, @PathVariable(required = true) String password) throws ParseException {
        User u = pharmacienRepository.loginAdmin(username);
        String pwd =  u.getPassword();
        if(pwd.equals(password)){
            if(u.getRole().equals("admin")){
                return "success";
            }else{
                return "vous navez pas le droit d'acces";
            }
        }else
            return "login ou mot de passe incorrect";

    }


}
