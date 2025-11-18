package org.example.foyer.interfaces;

import org.example.foyer.entities.Chambre;

import java.util.List;

public interface IChambreService {


    Chambre ajouterChambre(Chambre chambre);
    List<Chambre> afficherListeChambres();
    Chambre afficherChambreSelonID(long idChambre);
    Chambre modifierChambre(Chambre chambre);
    void supprimerChambre(long idChambre);
}
