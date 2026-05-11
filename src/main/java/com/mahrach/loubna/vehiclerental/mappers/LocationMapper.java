package com.mahrach.loubna.vehiclerental.mappers;

import com.mahrach.loubna.vehiclerental.dtos.LocationDTO;
import com.mahrach.loubna.vehiclerental.entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toDTO(Location location);
    Location toEntity(LocationDTO dto);
}
