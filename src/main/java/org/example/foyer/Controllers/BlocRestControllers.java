package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.foyer.interfaces.IBlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.foyer.entities.Bloc;

import java.util.List;

@Tag(name="Gestion Bloc")
@RestController
@RequestMapping("/bloc")
public class BlocRestControllers {

    @Autowired
    private IBlocService iBlocServices;

    @Operation(description = "Ajouter un bloc")
    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return iBlocServices.ajouterBloc(bloc);
    }

    @Operation(description = "Afficher tous les blocs")
    @GetMapping("/getAllBlocs")
    public List<Bloc> getAllBlocs() {
        return iBlocServices.afficherListeBlocs();
    }

    @Operation(description = "Afficher un bloc par ID")
    @GetMapping("/getBlocByID/{idB}")
    public Bloc getBlocByID(@PathVariable("idB") long idBloc) {
        return iBlocServices.afficherBlocSelonID(idBloc);
    }

    @Operation(description = "Mettre à jour un bloc")
    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return iBlocServices.modifierBloc(bloc);
    }

    @Operation(description = "Supprimer un bloc")
    @DeleteMapping("/deleteBloc/{idB}")
    public void deleteBloc(@PathVariable("idB") long idBloc) {
        iBlocServices.supprimerBloc(idBloc);
    }
}
