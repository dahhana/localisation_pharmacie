package com.example.backend.repository;

import com.example.backend.beans.Pharmacie;
import com.example.backend.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacienRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User findById(int id);
    @Query(value= "select u from User u where u.id = :user_id ")
    User findPharmacienById(@Param("user_id") int user_id);

    @Query(value="select u from User u where u.username = :username")
    User loginPharmacien(@Param("username") String username);

    @Query(value="select u from User u where u.username = :username")
    User loginAdmin(@Param("username") String username);




}
