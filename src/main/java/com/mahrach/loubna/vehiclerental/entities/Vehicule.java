package com.mahrach.loubna.vehiclerental.entities;

import com.mahrach.loubna.vehiclerental.enums.StatutVehicule;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String marque;
    private String modele;
    private String matricule;
    private Double prixParJour;
    private LocalDate dateMiseEnService;
    
    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;
    
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;
    
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Location> locations;
}
