package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.VoitureDTO;
import com.exam.vehiclerental.entities.Voiture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehiculeMapper.class)
public interface VoitureMapper {
    VoitureDTO toDTO(Voiture voiture);
    Voiture toEntity(VoitureDTO dto);
}
