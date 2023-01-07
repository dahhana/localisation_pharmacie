package com.example.backend.service;

import com.example.backend.beans.Zone;

public interface ZoneService {
    public Zone saveZone(Zone zone);
    public Zone updateZone(Zone zone);

    Zone getZoneById(int id);

    void deleteZone(Zone zone);

}
