package com.exam.vehiclerental.mappers;

import com.exam.vehiclerental.dtos.VoitureDTO;
import com.exam.vehiclerental.entities.Voiture;
import com.exam.vehiclerental.enums.BoiteVitesse;
import com.exam.vehiclerental.enums.StatutVehicule;
import com.exam.vehiclerental.enums.TypeCarburant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-11T15:43:37+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class VoitureMapperImpl implements VoitureMapper {

    @Override
    public VoitureDTO toDTO(Voiture voiture) {
        if ( voiture == null ) {
            return null;
        }

        VoitureDTO.VoitureDTOBuilder<?, ?> voitureDTO = VoitureDTO.builder();

        voitureDTO.id( voiture.getId() );
        voitureDTO.marque( voiture.getMarque() );
        voitureDTO.modele( voiture.getModele() );
        voitureDTO.matricule( voiture.getMatricule() );
        voitureDTO.prixParJour( voiture.getPrixParJour() );
        voitureDTO.dateMiseEnService( voiture.getDateMiseEnService() );
        if ( voiture.getStatut() != null ) {
            voitureDTO.statut( voiture.getStatut().name() );
        }
        voitureDTO.nombrePortes( voiture.getNombrePortes() );
        if ( voiture.getTypeCarburant() != null ) {
            voitureDTO.typeCarburant( voiture.getTypeCarburant().name() );
        }
        if ( voiture.getBoiteVitesse() != null ) {
            voitureDTO.boiteVitesse( voiture.getBoiteVitesse().name() );
        }

        return voitureDTO.build();
    }

    @Override
    public Voiture toEntity(VoitureDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Voiture.VoitureBuilder<?, ?> voiture = Voiture.builder();

        voiture.id( dto.getId() );
        voiture.marque( dto.getMarque() );
        voiture.modele( dto.getModele() );
        voiture.matricule( dto.getMatricule() );
        voiture.prixParJour( dto.getPrixParJour() );
        voiture.dateMiseEnService( dto.getDateMiseEnService() );
        if ( dto.getStatut() != null ) {
            voiture.statut( Enum.valueOf( StatutVehicule.class, dto.getStatut() ) );
        }
        voiture.nombrePortes( dto.getNombrePortes() );
        if ( dto.getTypeCarburant() != null ) {
            voiture.typeCarburant( Enum.valueOf( TypeCarburant.class, dto.getTypeCarburant() ) );
        }
        if ( dto.getBoiteVitesse() != null ) {
            voiture.boiteVitesse( Enum.valueOf( BoiteVitesse.class, dto.getBoiteVitesse() ) );
        }

        return voiture.build();
    }
}
