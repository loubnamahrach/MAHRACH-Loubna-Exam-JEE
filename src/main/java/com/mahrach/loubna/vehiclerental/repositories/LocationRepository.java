package com.mahrach.loubna.vehiclerental.repositories;

import com.mahrach.loubna.vehiclerental.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByVehiculeId(Long vehiculeId);
}
