package org.example.foyer.interfaces;

import org.example.foyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {


    Universite ajouterUniversite(Universite universite);
    List<Universite> afficherListeUniversite();
    Universite afficherUniversiteSelonID(long idUniversite);
    Universite modifierUniversite(Universite universite);
    void supprimerUniversite(long idUniversite);
}
