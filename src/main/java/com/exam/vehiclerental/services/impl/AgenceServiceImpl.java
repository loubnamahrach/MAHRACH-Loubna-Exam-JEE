package com.exam.vehiclerental.services.impl;

import com.exam.vehiclerental.dtos.AgenceDTO;
import com.exam.vehiclerental.entities.Agence;
import com.exam.vehiclerental.mappers.AgenceMapper;
import com.exam.vehiclerental.repositories.AgenceRepository;
import com.exam.vehiclerental.services.AgenceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AgenceServiceImpl implements AgenceService {

    private final AgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    public AgenceServiceImpl(AgenceRepository agenceRepository, AgenceMapper agenceMapper) {
        this.agenceRepository = agenceRepository;
        this.agenceMapper = agenceMapper;
    }

    @Override
    public AgenceDTO save(AgenceDTO dto) {
        Agence agence = agenceMapper.toEntity(dto);
        Agence saved = agenceRepository.save(agence);
        return agenceMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public AgenceDTO findById(Long id) {
        return agenceRepository.findById(id)
                .map(agenceMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Agence non trouvée avec l'id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgenceDTO> findAll() {
        return agenceRepository.findAll().stream()
                .map(agenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AgenceDTO findByNom(String nom) {
        Agence agence = agenceRepository.findByNom(nom);
        if (agence == null) {
            throw new RuntimeException("Agence non trouvée avec le nom: " + nom);
        }
        return agenceMapper.toDTO(agence);
    }

    @Override
    public AgenceDTO update(Long id, AgenceDTO dto) {
        Agence agence = agenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence non trouvée avec l'id: " + id));
        
        agence.setNom(dto.getNom());
        agence.setAdresse(dto.getAdresse());
        agence.setVille(dto.getVille());
        agence.setTelephone(dto.getTelephone());
        
        Agence updated = agenceRepository.save(agence);
        return agenceMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        agenceRepository.deleteById(id);
    }
}
