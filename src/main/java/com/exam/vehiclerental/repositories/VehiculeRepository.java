package com.exam.vehiclerental.repositories;

import com.exam.vehiclerental.entities.Vehicule;
import com.exam.vehiclerental.enums.StatutVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByAgenceId(Long agenceId);
    List<Vehicule> findByMarque(String marque);
}
