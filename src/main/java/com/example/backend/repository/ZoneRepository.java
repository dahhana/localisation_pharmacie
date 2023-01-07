package com.example.backend.repository;

import com.example.backend.beans.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    @Query(value= "select z.nom from Zone z where z.ville.nom = :ville")
    List<String> findAllZones(String ville);

    Zone findById(int id);
}
