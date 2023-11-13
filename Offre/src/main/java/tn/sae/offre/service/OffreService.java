package tn.sae.offre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sae.offre.entity.Offre;
import tn.sae.offre.repository.OffreRepository;

import java.util.List;

@Service
public class OffreService implements IOffreService {

    @Autowired
    OffreRepository offreRepository;
    @Override
    public void addOffre(Offre offre) {
            offreRepository.save(offre);
    }

    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();    }

    @Override
    public List<Offre> getOffreByTitre(String titre) {
        return offreRepository.findByTitre(titre);
    }
    @Override
    public List<Offre> getOffreByType(String type) {
        return offreRepository.findByType(type);
    }

    @Override
    public void DeleteOffreById(int idOffre) {
        Offre offre = offreRepository.findById(idOffre).orElse(null);

        if (offre == null) {
            throw new RuntimeException("L'offre avec l'ID " + idOffre + " n'a pas été trouvé.");
        }else {
            offreRepository.delete(offre);
        }


    }

    @Override
    public void UpdateOffreById(Integer id, Offre offre) {
        if (offreRepository.findById(id).orElse(null) != null) {
            offre.setId(id);
            offre.setType(offre.getType());
            offre.setDuree(offre.getDuree());
            offre.setTitre(offre.getTitre());
            offre.setDescription(offre.getDescription());
            offreRepository.save(offre);
        } else {
            throw new RuntimeException("Le partenariat avec l'ID " + offre.getId() + " n'a pas été trouvé.");
        }
    }
}
