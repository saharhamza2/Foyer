package org.example.foyer.Services;

import org.example.foyer.interfaces.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.foyer.entities.Reservation;
import org.example.foyer.repositories.ReservationRepository;

import java.util.List;

@Service
public class IReservationServicesImp implements IReservationService {


    @Autowired
    private  ReservationRepository reservationRepository;


    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> afficherListeReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation afficherReservationSelonID(Long idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}