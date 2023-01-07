package com.example.backend.service;

import com.example.backend.beans.Zone;
import com.example.backend.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneServiceImpl implements ZoneService{

    @Autowired
    ZoneRepository zoneRepository;

    public int getMaxId() {
        return zoneRepository.findAll().size()+1;
    }

    @Override
    public Zone saveZone(Zone zone) {
        zone.setId(getMaxId());
        return zoneRepository.save(zone);
    }

    @Override
    public Zone updateZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    @Override
    public Zone getZoneById(int id) {
        return zoneRepository.findById(id);
    }

    @Override
    public void deleteZone(Zone zone) {
        zoneRepository.delete(zone);
    }
}
