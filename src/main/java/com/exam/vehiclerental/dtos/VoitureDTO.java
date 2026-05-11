package com.exam.vehiclerental.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class VoitureDTO extends VehiculeDTO {
    private Integer nombrePortes;
    private String typeCarburant;
    private String boiteVitesse;
}
