package com.example.backend.repository;

import com.example.backend.beans.Pharmacie;
import com.example.backend.beans.PharmacieGarde;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into pharmacie_garde (garde_id, pharmacie_id, date_debut,date_fin) VALUES (?1, ?2,?3,?4)", nativeQuery = true)
    void inserPharmacieGarde(int gardeId, int pharmacieId, String dateDebut, String dateFin);


    @Query(value = "select p.pharmacie from PharmacieGarde p where p.garde.type like 'night' and p.pharmacie.zone.nom = :zone and p.pharmacie.zone.ville.nom = :ville")
    List<Pharmacie> getPharmacieGardeNuit(@Param("zone") String zone, @Param("ville") String ville);

    @Query(value = "select p.pharmacie from PharmacieGarde p where p.garde.type like 'jour' and p.pharmacie.zone.nom = :zone and p.pharmacie.zone.ville.nom = :ville")
    List<Pharmacie> getPharmacieGardeJour(@Param("zone") String zone, @Param("ville") String ville);

    @Query(value="select p.pharmacie, min(sqrt(power((p.pharmacie.latitude-:lat),2)+power((p.pharmacie.longitude-:lon),2))) from PharmacieGarde p where p.pharmacie.zone.nom = :zone and p.pharmacie.zone.ville.nom = :ville and p.garde.type like 'jour'")
    List<ArrayList> findMinDistanceJour(@Param("lat") double lat, @Param("lon") double lon, @Param("zone") String zone, @Param("ville") String ville);

    @Query(value="select p.pharmacie, min(sqrt(power((p.pharmacie.latitude-:lat),2)+power((p.pharmacie.longitude-:lon),2))) from PharmacieGarde p where p.pharmacie.zone.nom = :zone and p.pharmacie.zone.ville.nom = :ville and p.garde.type like 'night'")
    List<ArrayList> findMinDistanceNuit(@Param("lat") double lat, @Param("lon") double lon, @Param("zone") String zone, @Param("ville") String ville);


    PharmacieGarde findById(int id);
}
