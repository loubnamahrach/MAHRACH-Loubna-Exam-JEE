package com.exam.vehiclerental.services.impl;

import com.exam.vehiclerental.dtos.LocationDTO;
import com.exam.vehiclerental.entities.Location;
import com.exam.vehiclerental.mappers.LocationMapper;
import com.exam.vehiclerental.repositories.LocationRepository;
import com.exam.vehiclerental.services.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public LocationDTO save(LocationDTO dto) {
        Location location = locationMapper.toEntity(dto);
        Location saved = locationRepository.save(location);
        return locationMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public LocationDTO findById(Long id) {
        return locationRepository.findById(id)
                .map(locationMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Location non trouvée avec l'id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocationDTO> findAll() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocationDTO> findByVehiculeId(Long vehiculeId) {
        return locationRepository.findByVehiculeId(vehiculeId).stream()
                .map(locationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO update(Long id, LocationDTO dto) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location non trouvée avec l'id: " + id));
        
        location.setDateDebut(dto.getDateDebut());
        location.setDateFin(dto.getDateFin());
        location.setPrixTotal(dto.getPrixTotal());
        
        Location updated = locationRepository.save(location);
        return locationMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}
