package com.exam.vehiclerental.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class MotoDTO extends VehiculeDTO {
    private Integer cylindree;
    private String typeMoto;
    private Boolean casqueInclus;
}
