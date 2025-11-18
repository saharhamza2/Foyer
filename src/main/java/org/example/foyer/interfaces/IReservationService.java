package org.example.foyer.interfaces;

import org.example.foyer.entities.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation ajouterReservation(Reservation reservation);
    List<Reservation> afficherListeReservations();
    Reservation afficherReservationSelonID(Long idReservation);
    Reservation modifierReservation(Reservation reservation);
    void supprimerReservation(Long idReservation);
}
