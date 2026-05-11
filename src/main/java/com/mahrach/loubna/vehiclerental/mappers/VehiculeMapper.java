package com.mahrach.loubna.vehiclerental.mappers;

import com.mahrach.loubna.vehiclerental.dtos.VehiculeDTO;
import com.mahrach.loubna.vehiclerental.entities.Vehicule;
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
