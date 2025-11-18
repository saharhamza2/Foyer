package org.example.foyer.repositories;

import org.example.foyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    Bloc findByFoyerNomFoyer(String nom);
}
