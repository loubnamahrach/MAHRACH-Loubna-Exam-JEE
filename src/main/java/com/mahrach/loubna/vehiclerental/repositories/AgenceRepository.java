package com.mahrach.loubna.vehiclerental.repositories;

import com.mahrach.loubna.vehiclerental.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
    Agence findByNom(String nom);
}
