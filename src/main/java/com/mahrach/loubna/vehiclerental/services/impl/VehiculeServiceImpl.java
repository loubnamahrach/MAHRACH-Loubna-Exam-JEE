package com.mahrach.loubna.vehiclerental.services.impl;

import com.mahrach.loubna.vehiclerental.dtos.VehiculeDTO;
import com.mahrach.loubna.vehiclerental.entities.Vehicule;
import com.mahrach.loubna.vehiclerental.enums.StatutVehicule;
import com.mahrach.loubna.vehiclerental.mappers.VehiculeMapper;
import com.mahrach.loubna.vehiclerental.repositories.VehiculeRepository;
import com.mahrach.loubna.vehiclerental.services.VehiculeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    @Override
    public VehiculeDTO save(VehiculeDTO dto) {
        Vehicule vehicule = vehiculeMapper.toEntity(dto);
        Vehicule saved = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public VehiculeDTO findById(Long id) {
        return vehiculeRepository.findById(id)
                .map(vehiculeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Vehicule non trouvé avec l'id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeDTO> findAll() {
        return vehiculeRepository.findAll().stream()
                .map(vehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeDTO> findByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut).stream()
                .map(vehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeDTO> findByAgenceId(Long agenceId) {
        return vehiculeRepository.findByAgenceId(agenceId).stream()
                .map(vehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeDTO> findByMarque(String marque) {
        return vehiculeRepository.findByMarque(marque).stream()
                .map(vehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO update(Long id, VehiculeDTO dto) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule non trouvé avec l'id: " + id));
        
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        vehicule.setMatricule(dto.getMatricule());
        vehicule.setPrixParJour(dto.getPrixParJour());
        
        Vehicule updated = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }
}
