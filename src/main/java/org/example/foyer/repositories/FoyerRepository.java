package org.example.foyer.repositories;

import org.example.foyer.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    //List<Foyer> findByBlocsNomBlocAnd BlocsCapaiteBloc(Long capacite);
}
