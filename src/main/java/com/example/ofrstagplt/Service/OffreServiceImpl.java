package com.example.ofrstagplt.Service;

import com.example.ofrstagplt.Entities.Offre;
import com.example.ofrstagplt.Repositories.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreServiceImpl implements OffreService{

    @Autowired
    OffreRepository offreRepository;

    @Override
    public void ajouterUnOffre(Offre offre) {
        offreRepository.save(offre);
    }

    @Override
    public void supprimerUnOffre(Long id) {
        offreRepository.deleteById(id);
    }

    @Override
    public void modifierUnOffre(Long id, Offre offre) {
        Offre offre1 = offreRepository.findById(id).orElse(null);
        offre1.setTitre(offre.getTitre());
        offre1.setDescription(offre.getDescription());
        offre1.setExigences(offre.getExigences());
        offre1.setType(offre.getType());
        offreRepository.save(offre1);
    }

    @Override
    public List<Offre> afficherAllOffre() {
        return offreRepository.findAll();
    }

    @Override
    public List<Offre> afficherOffreParType(String type) {
        return offreRepository.findAllByType(type);
    }

    @Override
    public Offre updateOffre(Long id, Offre updatedOffre) {
Offre offre = offreRepository.findById(id).orElse(null);
        if (offre != null) {
            offre.setTitre(updatedOffre.getTitre());
            offre.setDescription(updatedOffre.getDescription());
            offre.setExigences(updatedOffre.getExigences());
            offre.setType(updatedOffre.getType());
            offreRepository.save(offre);
        }
        return offre;
    }
}
