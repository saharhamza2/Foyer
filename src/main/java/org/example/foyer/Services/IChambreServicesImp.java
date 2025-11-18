package org.example.foyer.Services;

import org.example.foyer.interfaces.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.foyer.entities.Chambre;
import org.example.foyer.repositories.ChambreRepository;

import java.util.List;

@Service
public class IChambreServicesImp implements IChambreService {


    @Autowired
    private  ChambreRepository chambreRepository;
    @Override
    public Chambre ajouterChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> afficherListeChambres() {
        return  chambreRepository.findAll();
    }

    @Override
    public Chambre afficherChambreSelonID(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public Chambre modifierChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void supprimerChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}
