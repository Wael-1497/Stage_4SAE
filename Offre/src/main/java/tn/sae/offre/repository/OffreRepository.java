package tn.sae.offre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sae.offre.entity.Offre;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Integer> {

    List<Offre> findByTitre(String titre);
    List<Offre> findByType(String type);
}
