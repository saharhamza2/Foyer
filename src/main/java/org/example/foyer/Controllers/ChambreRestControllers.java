package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.foyer.entities.Chambre;
import org.example.foyer.interfaces.IChambreService;

import java.util.List;

@Tag(name = "Gestion Chambre")
@RestController
@RequestMapping("/chambre")
public class ChambreRestControllers {

    @Autowired
    private IChambreService IChambreServices;

    @Operation(description = "Ajouter une chambre")
    @PostMapping("/addChambre")
    Chambre addChambre(@RequestBody Chambre chambre) {
        return IChambreServices.ajouterChambre(chambre);
    }

    @Operation(description = "Afficher toutes les chambres")
    @GetMapping("/getAllChambres")
    List<Chambre> getAllChambres() {
        return IChambreServices.afficherListeChambres();
    }

    @Operation(description = "Afficher une chambre par ID")
    @GetMapping("/getChambreByID/{idCh}")
    Chambre getChambreByID(@PathVariable("idCh") long idChambre) {
        return IChambreServices.afficherChambreSelonID(idChambre);
    }

    @Operation(description = "Mettre à jour une chambre")
    @PutMapping("/updateChambre")
    Chambre updateChambre(@RequestBody Chambre chambre) {
        return IChambreServices.modifierChambre(chambre);
    }

    @Operation(description = "Supprimer une chambre")
    @DeleteMapping("/deleteChambre/{idCh}")
    void deleteChambre(@PathVariable("idCh") long idChambre) {
        IChambreServices.supprimerChambre(idChambre);
    }
}
