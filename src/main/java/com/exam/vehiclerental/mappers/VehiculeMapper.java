package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.VehiculeDTO;
import com.exam.vehiclerental.entities.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {
    
    @Mapping(source = "agence.id", target = "agenceId")
    @Mapping(source = "agence.nom", target = "agenceNom")
    @Mapping(source = "statut", target = "statut")
    VehiculeDTO toDTO(Vehicule vehicule);
    
    @Mapping(source = "agenceId", target = "agence.id")
    Vehicule toEntity(VehiculeDTO dto);
}
