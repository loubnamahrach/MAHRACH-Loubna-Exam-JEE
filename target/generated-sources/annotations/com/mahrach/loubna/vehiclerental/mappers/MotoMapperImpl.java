package com.mahrach.loubna.vehiclerental.mappers;

import com.mahrach.loubna.vehiclerental.dtos.MotoDTO;
import com.mahrach.loubna.vehiclerental.entities.Moto;
import com.mahrach.loubna.vehiclerental.enums.StatutVehicule;
import com.mahrach.loubna.vehiclerental.enums.TypeMoto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-11T16:37:23+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class MotoMapperImpl implements MotoMapper {

    @Override
    public MotoDTO toDTO(Moto moto) {
        if ( moto == null ) {
            return null;
        }

        MotoDTO.MotoDTOBuilder<?, ?> motoDTO = MotoDTO.builder();

        motoDTO.id( moto.getId() );
        motoDTO.marque( moto.getMarque() );
        motoDTO.modele( moto.getModele() );
        motoDTO.matricule( moto.getMatricule() );
        motoDTO.prixParJour( moto.getPrixParJour() );
        motoDTO.dateMiseEnService( moto.getDateMiseEnService() );
        if ( moto.getStatut() != null ) {
            motoDTO.statut( moto.getStatut().name() );
        }
        motoDTO.cylindree( moto.getCylindree() );
        if ( moto.getTypeMoto() != null ) {
            motoDTO.typeMoto( moto.getTypeMoto().name() );
        }
        motoDTO.casqueInclus( moto.getCasqueInclus() );

        return motoDTO.build();
    }

    @Override
    public Moto toEntity(MotoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Moto.MotoBuilder<?, ?> moto = Moto.builder();

        moto.id( dto.getId() );
        moto.marque( dto.getMarque() );
        moto.modele( dto.getModele() );
        moto.matricule( dto.getMatricule() );
        moto.prixParJour( dto.getPrixParJour() );
        moto.dateMiseEnService( dto.getDateMiseEnService() );
        if ( dto.getStatut() != null ) {
            moto.statut( Enum.valueOf( StatutVehicule.class, dto.getStatut() ) );
        }
        moto.cylindree( dto.getCylindree() );
        if ( dto.getTypeMoto() != null ) {
            moto.typeMoto( Enum.valueOf( TypeMoto.class, dto.getTypeMoto() ) );
        }
        moto.casqueInclus( dto.getCasqueInclus() );

        return moto.build();
    }
}
