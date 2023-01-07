package com.example.backend.service;

import com.example.backend.beans.User;
import com.example.backend.repository.PharmacienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacienServiceImpl implements PharmacienService{
    @Autowired
    private PharmacienRepository pharmacienRepository;

    @Override
    public User savePharmacien(User pharmacien) {
        pharmacien.setId(getMaxId());
        return pharmacienRepository.save(pharmacien);
    }

    @Override
    public User updatePharmacien(User pharmacien) {
        return pharmacienRepository.save(pharmacien);
    }

    @Override
    public User getPharmacienById(int id) {
        return pharmacienRepository.findById(id);
    }

    @Override
    public void deletePharmacien(User pharmacien) {
        pharmacienRepository.delete(pharmacien);
    }

    public int getMaxId() {
        return pharmacienRepository.findAll().size()+1;
    }
}
