package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.AgenceDTO;
import com.exam.vehiclerental.entities.Agence;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-11T15:43:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class AgenceMapperImpl implements AgenceMapper {

    @Override
    public AgenceDTO toDTO(Agence agence) {
        if ( agence == null ) {
            return null;
        }

        AgenceDTO.AgenceDTOBuilder agenceDTO = AgenceDTO.builder();

        agenceDTO.id( agence.getId() );
        agenceDTO.nom( agence.getNom() );
        agenceDTO.adresse( agence.getAdresse() );
        agenceDTO.ville( agence.getVille() );
        agenceDTO.telephone( agence.getTelephone() );

        return agenceDTO.build();
    }

    @Override
    public Agence toEntity(AgenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Agence.AgenceBuilder agence = Agence.builder();

        agence.id( dto.getId() );
        agence.nom( dto.getNom() );
        agence.adresse( dto.getAdresse() );
        agence.ville( dto.getVille() );
        agence.telephone( dto.getTelephone() );

        return agence.build();
    }
}
