package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.foyer.entities.Reservation;
import org.example.foyer.interfaces.IReservationService;

import java.util.List;

@Tag(name = "Gestion Reservation")
@RestController
@RequestMapping("/reservation")
public class ReservationRestControllers {

    @Autowired
    private IReservationService iReservationServices;

    @Operation(description = "Ajouter une réservation")
    @PostMapping("/addReservation")
    Reservation addReservation(@RequestBody Reservation reservation) {
        return iReservationServices.ajouterReservation(reservation);
    }

    @Operation(description = "Afficher toutes les réservations")
    @GetMapping("/getAllReservations")
    List<Reservation> getAllReservations() {
        return iReservationServices.afficherListeReservations();
    }

    @Operation(description = "Afficher une réservation par ID")
    @GetMapping("/getReservationByID/{idR}")
    Reservation getReservationByID(@PathVariable("idR") Long idReservation) {
        return iReservationServices.afficherReservationSelonID(idReservation);
    }

    @Operation(description = "Mettre à jour une réservation")
    @PutMapping("/updateReservation")
    Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservationServices.modifierReservation(reservation);
    }

    @Operation(description = "Supprimer une réservation")
    @DeleteMapping("/deleteReservation/{idR}")
    void deleteReservation(@PathVariable("idR") Long idReservation) {
        iReservationServices.supprimerReservation(idReservation);
    }
}
