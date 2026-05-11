package com.mahrach.loubna.vehiclerental.mappers;

import com.mahrach.loubna.vehiclerental.dtos.AgenceDTO;
import com.mahrach.loubna.vehiclerental.entities.Agence;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgenceMapper {
    AgenceDTO toDTO(Agence agence);
    Agence toEntity(AgenceDTO dto);
}
