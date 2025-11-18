package org.example.foyer.interfaces;

import org.example.foyer.entities.Bloc;

import java.util.List;

public interface IBlocService {

    Bloc ajouterBloc(Bloc bloc);
    List<Bloc> afficherListeBlocs();
    Bloc afficherBlocSelonID(long idBloc);
    Bloc modifierBloc(Bloc bloc);
    void supprimerBloc(long idBloc);
}
