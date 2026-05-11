package com.mahrach.loubna.vehiclerental.services;

import com.mahrach.loubna.vehiclerental.dtos.VehiculeDTO;
import com.mahrach.loubna.vehiclerental.enums.StatutVehicule;

import java.util.List;

public interface VehiculeService {
    VehiculeDTO save(VehiculeDTO dto);
    VehiculeDTO findById(Long id);
    List<VehiculeDTO> findAll();
    List<VehiculeDTO> findByStatut(StatutVehicule statut);
    List<VehiculeDTO> findByAgenceId(Long agenceId);
    List<VehiculeDTO> findByMarque(String marque);
    VehiculeDTO update(Long id, VehiculeDTO dto);
    void delete(Long id);
}
