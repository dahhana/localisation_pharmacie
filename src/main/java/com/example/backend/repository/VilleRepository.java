package com.example.backend.repository;

import com.example.backend.beans.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findById(int id);
    @Query(value= "select v.nom from Ville v")
    List<String> findAllVilles();
}
