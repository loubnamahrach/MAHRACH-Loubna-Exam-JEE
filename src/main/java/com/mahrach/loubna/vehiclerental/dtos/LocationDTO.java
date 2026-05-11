package com.mahrach.loubna.vehiclerental.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Double prixTotal;
    private Long vehiculeId;
}
