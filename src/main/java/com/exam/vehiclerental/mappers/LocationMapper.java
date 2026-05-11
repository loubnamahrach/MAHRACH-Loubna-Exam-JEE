package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.LocationDTO;
import com.exam.vehiclerental.entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toDTO(Location location);
    Location toEntity(LocationDTO dto);
}
