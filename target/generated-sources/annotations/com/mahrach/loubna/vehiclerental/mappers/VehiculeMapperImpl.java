package com.mahrach.loubna.vehiclerental.mappers;

import com.mahrach.loubna.vehiclerental.dtos.VehiculeDTO;
import com.mahrach.loubna.vehiclerental.entities.Agence;
import com.mahrach.loubna.vehiclerental.entities.Vehicule;
import com.mahrach.loubna.vehiclerental.enums.StatutVehicule;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-11T16:37:21+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class VehiculeMapperImpl implements VehiculeMapper {

    @Override
    public VehiculeDTO toDTO(Vehicule vehicule) {
        if ( vehicule == null ) {
            return null;
        }

        VehiculeDTO.VehiculeDTOBuilder<?, ?> vehiculeDTO = VehiculeDTO.builder();

        vehiculeDTO.agenceId( vehiculeAgenceId( vehicule ) );
        vehiculeDTO.agenceNom( vehiculeAgenceNom( vehicule ) );
        if ( vehicule.getStatut() != null ) {
            vehiculeDTO.statut( vehicule.getStatut().name() );
        }
        vehiculeDTO.id( vehicule.getId() );
        vehiculeDTO.marque( vehicule.getMarque() );
        vehiculeDTO.modele( vehicule.getModele() );
        vehiculeDTO.matricule( vehicule.getMatricule() );
        vehiculeDTO.prixParJour( vehicule.getPrixParJour() );
        vehiculeDTO.dateMiseEnService( vehicule.getDateMiseEnService() );

        return vehiculeDTO.build();
    }

    @Override
    public Vehicule toEntity(VehiculeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Vehicule.VehiculeBuilder<?, ?> vehicule = Vehicule.builder();

        vehicule.agence( vehiculeDTOToAgence( dto ) );
        vehicule.id( dto.getId() );
        vehicule.marque( dto.getMarque() );
        vehicule.modele( dto.getModele() );
        vehicule.matricule( dto.getMatricule() );
        vehicule.prixParJour( dto.getPrixParJour() );
        vehicule.dateMiseEnService( dto.getDateMiseEnService() );
        if ( dto.getStatut() != null ) {
            vehicule.statut( Enum.valueOf( StatutVehicule.class, dto.getStatut() ) );
        }

        return vehicule.build();
    }

    private Long vehiculeAgenceId(Vehicule vehicule) {
        if ( vehicule == null ) {
            return null;
        }
        Agence agence = vehicule.getAgence();
        if ( agence == null ) {
            return null;
        }
        Long id = agence.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String vehiculeAgenceNom(Vehicule vehicule) {
        if ( vehicule == null ) {
            return null;
        }
        Agence agence = vehicule.getAgence();
        if ( agence == null ) {
            return null;
        }
        String nom = agence.getNom();
        if ( nom == null ) {
            return null;
        }
        return nom;
    }

    protected Agence vehiculeDTOToAgence(VehiculeDTO vehiculeDTO) {
        if ( vehiculeDTO == null ) {
            return null;
        }

        Agence.AgenceBuilder agence = Agence.builder();

        agence.id( vehiculeDTO.getAgenceId() );

        return agence.build();
    }
}
