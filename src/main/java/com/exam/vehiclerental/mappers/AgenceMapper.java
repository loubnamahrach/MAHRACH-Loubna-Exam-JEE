package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.AgenceDTO;
import com.exam.vehiclerental.entities.Agence;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgenceMapper {
    AgenceDTO toDTO(Agence agence);
    Agence toEntity(AgenceDTO dto);
}
