package com.exam.vehiclerental.config;

import com.exam.vehiclerental.entities.*;
import com.exam.vehiclerental.enums.*;
import com.exam.vehiclerental.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;
    private final LocationRepository locationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AgenceRepository agenceRepository, VehiculeRepository vehiculeRepository,
                          LocationRepository locationRepository, UtilisateurRepository utilisateurRepository,
                          PasswordEncoder passwordEncoder) {
        this.agenceRepository = agenceRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.locationRepository = locationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Guard: only seed if database is empty
        if (agenceRepository.count() > 0) {
            System.out.println("ℹ️  Base de données déjà initialisée.");
            return;
        }

        // ── Utilisateurs ──────────────────────────────────────────────────────
        utilisateurRepository.save(Utilisateur.builder()
                .username("admin")
                .motdepasse(passwordEncoder.encode("admin123"))
                .email("admin@vehiclerental.com")
                .nom("Admin").prenom("System")
                .role(Role.ROLE_ADMIN).enabled(true).build());

        utilisateurRepository.save(Utilisateur.builder()
                .username("employe")
                .motdepasse(passwordEncoder.encode("employe123"))
                .email("employe@vehiclerental.com")
                .nom("Dupont").prenom("Jean")
                .role(Role.ROLE_EMPLOYE).enabled(true).build());

        utilisateurRepository.save(Utilisateur.builder()
                .username("client")
                .motdepasse(passwordEncoder.encode("client123"))
                .email("client@vehiclerental.com")
                .nom("Martin").prenom("Pierre")
                .role(Role.ROLE_CLIENT).enabled(true).build());

        // ── Agences ───────────────────────────────────────────────────────────
        Agence agence1 = agenceRepository.save(Agence.builder()
                .nom("Agence Casablanca")
                .adresse("Avenue Hassan II")
                .ville("Casablanca")
                .telephone("0522123456")
                .build());

        Agence agence2 = agenceRepository.save(Agence.builder()
                .nom("Agence Marrakech")
                .adresse("Boulevard de la Menara")
                .ville("Marrakech")
                .telephone("0524987654")
                .build());

        // ── Voitures ──────────────────────────────────────────────────────────
        Voiture voiture1 = (Voiture) vehiculeRepository.save(Voiture.builder()
                .marque("BMW").modele("320i").matricule("CAS-2024-001")
                .prixParJour(500.0).dateMiseEnService(LocalDate.of(2022, 1, 15))
                .statut(StatutVehicule.DISPONIBLE).agence(agence1)
                .nombrePortes(4).typeCarburant(TypeCarburant.ESSENCE)
                .boiteVitesse(BoiteVitesse.AUTOMATIQUE).build());

        vehiculeRepository.save(Voiture.builder()
                .marque("Mercedes").modele("C-Class").matricule("CAS-2024-002")
                .prixParJour(700.0).dateMiseEnService(LocalDate.of(2023, 6, 20))
                .statut(StatutVehicule.DISPONIBLE).agence(agence1)
                .nombrePortes(4).typeCarburant(TypeCarburant.DIESEL)
                .boiteVitesse(BoiteVitesse.AUTOMATIQUE).build());

        vehiculeRepository.save(Voiture.builder()
                .marque("Toyota").modele("Corolla").matricule("MAR-2024-001")
                .prixParJour(400.0).dateMiseEnService(LocalDate.of(2021, 3, 10))
                .statut(StatutVehicule.DISPONIBLE).agence(agence2)
                .nombrePortes(4).typeCarburant(TypeCarburant.HYBRIDE)
                .boiteVitesse(BoiteVitesse.AUTOMATIQUE).build());

        // ── Motos ─────────────────────────────────────────────────────────────
        vehiculeRepository.save(Moto.builder()
                .marque("Yamaha").modele("MT-09").matricule("CAS-2024-003")
                .prixParJour(250.0).dateMiseEnService(LocalDate.of(2023, 1, 5))
                .statut(StatutVehicule.DISPONIBLE).agence(agence1)
                .cylindree(889).typeMoto(TypeMoto.ROADSTER).casqueInclus(true).build());

        vehiculeRepository.save(Moto.builder()
                .marque("Honda").modele("CB500").matricule("MAR-2024-002")
                .prixParJour(200.0).dateMiseEnService(LocalDate.of(2022, 9, 12))
                .statut(StatutVehicule.DISPONIBLE).agence(agence2)
                .cylindree(471).typeMoto(TypeMoto.TOURING).casqueInclus(true).build());

        // ── Location exemple ──────────────────────────────────────────────────
        locationRepository.save(Location.builder()
                .dateDebut(LocalDate.of(2026, 5, 1))
                .dateFin(LocalDate.of(2026, 5, 8))
                .prixTotal(3500.0)
                .vehicule(voiture1)
                .build());

        System.out.println("✅ Base de données initialisée avec les données de test!");
        System.out.println("   Comptes: admin/admin123 | employe/employe123 | client/client123");
    }
}
