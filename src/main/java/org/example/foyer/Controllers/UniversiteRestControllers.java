package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.foyer.entities.Universite;
import org.example.foyer.interfaces.IUniversiteService;

import java.util.List;

@Tag(name = "Gestion Universite")
@RestController
@RequestMapping("/universite")
public class UniversiteRestControllers {

    @Autowired
    private IUniversiteService iUniversiteServices;

    @Operation(description = "Ajouter une université")
    @PostMapping("/addUniveriste")
    Universite addUniveriste(@RequestBody Universite universite) {
        return iUniversiteServices.ajouterUniversite(universite);
    }

    @Operation(description = "Afficher toutes les universités")
    @GetMapping("/getAllUniversites")
    List<Universite> getAllUniversites() {
        return iUniversiteServices.afficherListeUniversite();
    }

    @Operation(description = "Afficher une université par ID")
    @GetMapping("/getUniversiteByID/{idU}")
    Universite getUniversiteByID(@PathVariable("idU") long idUniversite) {
        return iUniversiteServices.afficherUniversiteSelonID(idUniversite);
    }

    @Operation(description = "Mettre à jour une université")
    @PutMapping("/updateUniversite")
    Universite updateUniversite(@RequestBody Universite universite) {
        return iUniversiteServices.modifierUniversite(universite);
    }


    @Operation(description = "Supprimer une université")
    @DeleteMapping("/deleteUniversite/{idU}")
    void deleteUniversite(@PathVariable("idU") long idUniversite) {
        iUniversiteServices.supprimerUniversite(idUniversite);
    }
}
