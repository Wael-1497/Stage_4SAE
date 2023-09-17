package com.example.ofrstagplt.Repositories;

import com.example.ofrstagplt.Entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
    List<Offre> findAllByType(String type);
}
