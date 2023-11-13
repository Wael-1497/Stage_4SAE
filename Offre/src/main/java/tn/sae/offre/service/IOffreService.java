package tn.sae.offre.service;

import tn.sae.offre.entity.Offre;

import java.util.List;

public interface IOffreService {
    void addOffre(Offre offre);
    List<Offre> getAllOffres();
    List<Offre> getOffreByTitre(String titre);
    void DeleteOffreById(int idOffre);
    void UpdateOffreById(Integer id, Offre offre);
    List<Offre> getOffreByType(String type);
}
