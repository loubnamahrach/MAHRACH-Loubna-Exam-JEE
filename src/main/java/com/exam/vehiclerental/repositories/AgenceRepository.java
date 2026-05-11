package com.exam.vehiclerental.repositories;

import com.exam.vehiclerental.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
    Agence findByNom(String nom);
}
