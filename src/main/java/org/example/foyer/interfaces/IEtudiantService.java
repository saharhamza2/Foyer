package org.example.foyer.interfaces;

import org.example.foyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {


    Etudiant ajouterEtudiant(Etudiant etudiant);
    List<Etudiant> afficherListeEtudiant();
    Etudiant afficherEtudiantSelonID(long idEtudiant);
    Etudiant modifierEtudiant(Etudiant etudiant);
    void supprimerEtudiant(long idEtudiant);
}
