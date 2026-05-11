package com.mahrach.loubna.vehiclerental.mappers;

import com.mahrach.loubna.vehiclerental.dtos.MotoDTO;
import com.mahrach.loubna.vehiclerental.entities.Moto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehiculeMapper.class)
public interface MotoMapper {
    MotoDTO toDTO(Moto moto);
    Moto toEntity(MotoDTO dto);
}
