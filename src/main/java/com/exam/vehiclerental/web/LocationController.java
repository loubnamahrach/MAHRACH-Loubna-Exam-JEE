package com.exam.vehiclerental.web;

import com.exam.vehiclerental.dtos.LocationDTO;
import com.exam.vehiclerental.services.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Locations", description = "API de gestion des locations de véhicules")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    @Operation(summary = "Récupérer toutes les locations")
    @ApiResponse(responseCode = "200", description = "Liste des locations")
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        return ResponseEntity.ok(locationService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une location par ID")
    @ApiResponse(responseCode = "200", description = "Location trouvée")
    @ApiResponse(responseCode = "404", description = "Location non trouvée")
    public ResponseEntity<LocationDTO> getLocation(
            @PathVariable @Parameter(description = "ID de la location") Long id) {
        return ResponseEntity.ok(locationService.findById(id));
    }

    @GetMapping("/vehicule/{vehiculeId}")
    @Operation(summary = "Récupérer l'historique des locations d'un véhicule")
    @ApiResponse(responseCode = "200", description = "Historique des locations")
    public ResponseEntity<List<LocationDTO>> getLocationsByVehicule(
            @PathVariable @Parameter(description = "ID du véhicule") Long vehiculeId) {
        return ResponseEntity.ok(locationService.findByVehiculeId(vehiculeId));
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle location")
    @ApiResponse(responseCode = "201", description = "Location créée avec succès")
    public ResponseEntity<LocationDTO> createLocation(
            @RequestBody @Parameter(description = "Données de la location") LocationDTO dto) {
        LocationDTO created = locationService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une location")
    @ApiResponse(responseCode = "200", description = "Location mise à jour")
    @ApiResponse(responseCode = "404", description = "Location non trouvée")
    public ResponseEntity<LocationDTO> updateLocation(
            @PathVariable @Parameter(description = "ID de la location") Long id,
            @RequestBody @Parameter(description = "Données mises à jour") LocationDTO dto) {
        LocationDTO updated = locationService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une location")
    @ApiResponse(responseCode = "204", description = "Location supprimée")
    @ApiResponse(responseCode = "404", description = "Location non trouvée")
    public ResponseEntity<Void> deleteLocation(
            @PathVariable @Parameter(description = "ID de la location") Long id) {
        locationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
