package com.exam.vehiclerental.entities;

import com.exam.vehiclerental.enums.BoiteVitesse;
import com.exam.vehiclerental.enums.TypeCarburant;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("VOITURE")
public class Voiture extends Vehicule {
    private Integer nombrePortes;
    
    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;
    
    @Enumerated(EnumType.STRING)
    private BoiteVitesse boiteVitesse;
}
