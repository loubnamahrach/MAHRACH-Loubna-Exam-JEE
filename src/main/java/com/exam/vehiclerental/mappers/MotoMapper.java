package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.MotoDTO;
import com.exam.vehiclerental.entities.Moto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehiculeMapper.class)
public interface MotoMapper {
    MotoDTO toDTO(Moto moto);
    Moto toEntity(MotoDTO dto);
}
