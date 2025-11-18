package org.example.foyer.Services;

import org.example.foyer.interfaces.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.foyer.entities.Etudiant;
import org.example.foyer.repositories.EtudiantRepository;

import java.util.List;

@Service
public class IEtudiantServicesImp implements IEtudiantService {


    @Autowired
    private  EtudiantRepository etudiantRepository;
    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> afficherListeEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant afficherEtudiantSelonID(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public Etudiant modifierEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
