package com.mahrach.loubna.vehiclerental.entities;

import com.mahrach.loubna.vehiclerental.enums.TypeMoto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("MOTO")
public class Moto extends Vehicule {
    private Integer cylindree;
    
    @Enumerated(EnumType.STRING)
    private TypeMoto typeMoto;
    
    private Boolean casqueInclus;
}
