package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.foyer.entities.Foyer;
import org.example.foyer.interfaces.IFoyerService;

import java.util.List;

@Tag(name = "Gestion Foyer")
@RestController
@RequestMapping("/foyer")
public class FoyerRestControllers {

    @Autowired
    private IFoyerService iFoyerServices;

    @Operation(description = "Ajouter un foyer")
    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer foyer) {
        return iFoyerServices.ajouterFoyer(foyer);
    }

    @Operation(description = "Afficher tous les foyers")
    @GetMapping("/getAllFoyers")
    List<Foyer> getAllFoyers() {
        return iFoyerServices.afficherListeFoyers();
    }

    @Operation(description = "Afficher un foyer par ID")
    @GetMapping("/getFoyerByID/{idF}")
    Foyer getFoyerByID(@PathVariable("idF") long idFoyer) {
        return iFoyerServices.afficherFoyerSelonID(idFoyer);
    }

    @Operation(description = "Mettre à jour un foyer")
    @PutMapping("/updateFoyer")
    Foyer updateFoyer(@RequestBody Foyer foyer) {
        return iFoyerServices.modifierFoyer(foyer);
    }

    @Operation(description = "Supprimer un foyer")
    @DeleteMapping("/deleteFoyer/{idF}")
    void deleteFoyer(@PathVariable("idF") long idFoyer) {
        iFoyerServices.supprimerFoyer(idFoyer);
    }
}
