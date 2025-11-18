package org.example.foyer.Services;

import org.example.foyer.interfaces.IBlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.foyer.entities.Bloc;
import org.example.foyer.repositories.BlocRepository;

import java.util.List;

@Service
public class IBlocServicesImp implements IBlocService {

    @Autowired
    private  BlocRepository blocRepository;
    @Override
    public Bloc ajouterBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> afficherListeBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc afficherBlocSelonID(long idBloc) {
        return blocRepository.getReferenceById(idBloc);
    }

    @Override
    public Bloc modifierBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void supprimerBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}
