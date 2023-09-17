package com.example.ofrstagplt.Service;

import com.example.ofrstagplt.Entities.Offre;

import java.util.List;

public interface OffreService {
    public void ajouterUnOffre(Offre offre);
    public void supprimerUnOffre(Long id);
    public void modifierUnOffre(Long id, Offre offre);
    List<Offre> afficherAllOffre();
    List<Offre> afficherOffreParType(String type);

    Offre updateOffre(Long id, Offre updatedOffre);
}
