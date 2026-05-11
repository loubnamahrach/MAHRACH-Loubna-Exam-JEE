package com.exam.vehiclerental.entities;

import com.exam.vehiclerental.enums.TypeMoto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("MOTO")
public class Moto extends Vehicule {
    private Integer cylindree;
    
    @Enumerated(EnumType.STRING)
    private TypeMoto typeMoto;
    
    private Boolean casqueInclus;
}
