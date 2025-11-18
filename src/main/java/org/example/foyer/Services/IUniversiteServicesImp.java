package org.example.foyer.Services;

import org.example.foyer.entities.Foyer;
import org.example.foyer.interfaces.IUniversiteService;
import org.example.foyer.repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.foyer.entities.Universite;
import org.example.foyer.repositories.UniversiteRepository;

import java.util.List;

@Service
public class IUniversiteServicesImp implements IUniversiteService {


    @Autowired
    private  UniversiteRepository universiteRepository;


    @Override
    public Universite ajouterUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> afficherListeUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite afficherUniversiteSelonID(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public Universite modifierUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

}