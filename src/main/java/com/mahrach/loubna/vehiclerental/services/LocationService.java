package com.mahrach.loubna.vehiclerental.services;

import com.mahrach.loubna.vehiclerental.dtos.LocationDTO;

import java.util.List;

public interface LocationService {
    LocationDTO save(LocationDTO dto);
    LocationDTO findById(Long id);
    List<LocationDTO> findAll();
    List<LocationDTO> findByVehiculeId(Long vehiculeId);
    LocationDTO update(Long id, LocationDTO dto);
    void delete(Long id);
}
