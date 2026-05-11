package com.mahrach.loubna.vehiclerental.mappers;

import com.mahrach.loubna.vehiclerental.dtos.VoitureDTO;
import com.mahrach.loubna.vehiclerental.entities.Voiture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehiculeMapper.class)
public interface VoitureMapper {
    VoitureDTO toDTO(Voiture voiture);
    Voiture toEntity(VoitureDTO dto);
}
