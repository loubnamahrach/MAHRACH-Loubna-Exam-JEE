package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.LocationDTO;
import com.exam.vehiclerental.entities.Location;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-11T15:43:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDTO toDTO(Location location) {
        if ( location == null ) {
            return null;
        }

        LocationDTO.LocationDTOBuilder locationDTO = LocationDTO.builder();

        locationDTO.id( location.getId() );
        locationDTO.dateDebut( location.getDateDebut() );
        locationDTO.dateFin( location.getDateFin() );
        locationDTO.prixTotal( location.getPrixTotal() );

        return locationDTO.build();
    }

    @Override
    public Location toEntity(LocationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Location.LocationBuilder location = Location.builder();

        location.id( dto.getId() );
        location.dateDebut( dto.getDateDebut() );
        location.dateFin( dto.getDateFin() );
        location.prixTotal( dto.getPrixTotal() );

        return location.build();
    }
}
