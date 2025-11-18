package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.foyer.entities.Etudiant;
import org.example.foyer.interfaces.IEtudiantService;

import java.util.List;

@Tag(name = "Gestion Etudiant")
@RestController
@RequestMapping("/etudiant")
public class EtudiantRestControllers {

    @Autowired
    private IEtudiantService iEtudiantServices;

    @Operation(description = "Ajouter un étudiant")
    @PostMapping("/addEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantServices.ajouterEtudiant(etudiant);
    }

    @Operation(description = "Afficher la liste de tous les étudiants")
    @GetMapping("/getAllEtudiants")
    List<Etudiant> getAllEtudiants() {
        return iEtudiantServices.afficherListeEtudiant();
    }

    @Operation(description = "Afficher un étudiant par ID")
    @GetMapping("/getEtudiantByID/{idEt}")
    Etudiant getEtudiantByID(@PathVariable("idEt") long idEtudiant) {
        return iEtudiantServices.afficherEtudiantSelonID(idEtudiant);
    }

    @Operation(description = "Mettre à jour un étudiant")
    @PutMapping("/updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantServices.modifierEtudiant(etudiant);
    }

    @Operation(description = "Supprimer un étudiant par ID")
    @DeleteMapping("/deleteEtudiant/{idEt}")
    void deleteEtudiant(@PathVariable("idEt") long idEtudiant) {
        iEtudiantServices.supprimerEtudiant(idEtudiant);
    }
}
