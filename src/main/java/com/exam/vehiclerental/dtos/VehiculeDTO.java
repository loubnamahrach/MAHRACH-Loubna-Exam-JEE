package com.exam.vehiclerental.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class VehiculeDTO {
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private Double prixParJour;
    private LocalDate dateMiseEnService;
    private String statut;
    private Long agenceId;
    private String agenceNom;
}
