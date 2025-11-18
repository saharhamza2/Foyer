package org.example.foyer.interfaces;

import org.example.foyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer ajouterFoyer(Foyer foyer);
    List<Foyer> afficherListeFoyers();
    Foyer afficherFoyerSelonID(long idFoyer);
    Foyer modifierFoyer(Foyer foyer);
    void supprimerFoyer(long idFoyer);
}
