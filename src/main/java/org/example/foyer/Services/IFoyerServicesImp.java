package org.example.foyer.Services;

import org.example.foyer.interfaces.IFoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.foyer.entities.Foyer;
import org.example.foyer.repositories.FoyerRepository;

import java.util.List;

@Service
public class IFoyerServicesImp implements IFoyerService {

    @Autowired
    private  FoyerRepository foyerRepository;
    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> afficherListeFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer afficherFoyerSelonID(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public Foyer modifierFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void supprimerFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}
