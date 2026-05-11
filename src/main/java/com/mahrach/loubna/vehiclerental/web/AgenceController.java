package com.mahrach.loubna.vehiclerental.web;

import com.mahrach.loubna.vehiclerental.dtos.AgenceDTO;
import com.mahrach.loubna.vehiclerental.services.AgenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@Tag(name = "Agences", description = "API de gestion des agences")
public class AgenceController {

    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    @Operation(summary = "Récupérer toutes les agences")
    @ApiResponse(responseCode = "200", description = "Liste des agences")
    public ResponseEntity<List<AgenceDTO>> getAllAgences() {
        return ResponseEntity.ok(agenceService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une agence par ID")
    @ApiResponse(responseCode = "200", description = "Agence trouvée")
    @ApiResponse(responseCode = "404", description = "Agence non trouvée")
    public ResponseEntity<AgenceDTO> getAgence(
            @PathVariable @Parameter(description = "ID de l'agence") Long id) {
        return ResponseEntity.ok(agenceService.findById(id));
    }

    @GetMapping("/nom/{nom}")
    @Operation(summary = "Récupérer une agence par nom")
    @ApiResponse(responseCode = "200", description = "Agence trouvée")
    @ApiResponse(responseCode = "404", description = "Agence non trouvée")
    public ResponseEntity<AgenceDTO> getAgenceByNom(
            @PathVariable @Parameter(description = "Nom de l'agence") String nom) {
        return ResponseEntity.ok(agenceService.findByNom(nom));
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle agence")
    @ApiResponse(responseCode = "201", description = "Agence créée avec succès")
    public ResponseEntity<AgenceDTO> createAgence(
            @RequestBody @Parameter(description = "Données de l'agence") AgenceDTO dto) {
        AgenceDTO created = agenceService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une agence")
    @ApiResponse(responseCode = "200", description = "Agence mise à jour")
    @ApiResponse(responseCode = "404", description = "Agence non trouvée")
    public ResponseEntity<AgenceDTO> updateAgence(
            @PathVariable @Parameter(description = "ID de l'agence") Long id,
            @RequestBody @Parameter(description = "Données mises à jour") AgenceDTO dto) {
        AgenceDTO updated = agenceService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une agence")
    @ApiResponse(responseCode = "204", description = "Agence supprimée")
    @ApiResponse(responseCode = "404", description = "Agence non trouvée")
    public ResponseEntity<Void> deleteAgence(
            @PathVariable @Parameter(description = "ID de l'agence") Long id) {
        agenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
