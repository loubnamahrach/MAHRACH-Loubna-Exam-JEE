package com.mahrach.loubna.vehiclerental.web;

import com.mahrach.loubna.vehiclerental.dtos.VehiculeDTO;
import com.mahrach.loubna.vehiclerental.enums.StatutVehicule;
import com.mahrach.loubna.vehiclerental.services.VehiculeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@Tag(name = "Vehicules", description = "API de gestion des véhicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules")
    public ResponseEntity<List<VehiculeDTO>> getAllVehicules() {
        return ResponseEntity.ok(vehiculeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un véhicule par ID")
    @ApiResponse(responseCode = "200", description = "Véhicule trouvé")
    @ApiResponse(responseCode = "404", description = "Véhicule non trouvé")
    public ResponseEntity<VehiculeDTO> getVehicule(
            @PathVariable @Parameter(description = "ID du véhicule") Long id) {
        return ResponseEntity.ok(vehiculeService.findById(id));
    }

    @GetMapping("/statut/{statut}")
    @Operation(summary = "Récupérer les véhicules par statut")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules par statut")
    public ResponseEntity<List<VehiculeDTO>> getVehiculesByStatut(
            @PathVariable @Parameter(description = "Statut du véhicule") StatutVehicule statut) {
        return ResponseEntity.ok(vehiculeService.findByStatut(statut));
    }

    @GetMapping("/agence/{agenceId}")
    @Operation(summary = "Récupérer les véhicules d'une agence")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules de l'agence")
    public ResponseEntity<List<VehiculeDTO>> getVehiculesByAgence(
            @PathVariable @Parameter(description = "ID de l'agence") Long agenceId) {
        return ResponseEntity.ok(vehiculeService.findByAgenceId(agenceId));
    }

    @GetMapping("/marque/{marque}")
    @Operation(summary = "Récupérer les véhicules par marque")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules par marque")
    public ResponseEntity<List<VehiculeDTO>> getVehiculesByMarque(
            @PathVariable @Parameter(description = "Marque du véhicule") String marque) {
        return ResponseEntity.ok(vehiculeService.findByMarque(marque));
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau véhicule")
    @ApiResponse(responseCode = "201", description = "Véhicule créé avec succès")
    public ResponseEntity<VehiculeDTO> createVehicule(
            @RequestBody @Parameter(description = "Données du véhicule") VehiculeDTO dto) {
        VehiculeDTO created = vehiculeService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un véhicule")
    @ApiResponse(responseCode = "200", description = "Véhicule mis à jour")
    @ApiResponse(responseCode = "404", description = "Véhicule non trouvé")
    public ResponseEntity<VehiculeDTO> updateVehicule(
            @PathVariable @Parameter(description = "ID du véhicule") Long id,
            @RequestBody @Parameter(description = "Données mises à jour") VehiculeDTO dto) {
        VehiculeDTO updated = vehiculeService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un véhicule")
    @ApiResponse(responseCode = "204", description = "Véhicule supprimé")
    @ApiResponse(responseCode = "404", description = "Véhicule non trouvé")
    public ResponseEntity<Void> deleteVehicule(
            @PathVariable @Parameter(description = "ID du véhicule") Long id) {
        vehiculeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
