package com.example.backend.service;

import com.example.backend.beans.User;

public interface PharmacienService {
    public User savePharmacien(User pharmacien);
    public User updatePharmacien(User pharmacien);


    User getPharmacienById(int id);

    void deletePharmacien(User pharmacien);
}
