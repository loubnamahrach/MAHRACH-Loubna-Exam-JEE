package com.mahrach.loubna.vehiclerental.services;

import com.mahrach.loubna.vehiclerental.dtos.AgenceDTO;

import java.util.List;

public interface AgenceService {
    AgenceDTO save(AgenceDTO dto);
    AgenceDTO findById(Long id);
    List<AgenceDTO> findAll();
    AgenceDTO findByNom(String nom);
    AgenceDTO update(Long id, AgenceDTO dto);
    void delete(Long id);
}
