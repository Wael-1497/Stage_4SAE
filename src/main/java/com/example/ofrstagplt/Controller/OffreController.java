package com.example.ofrstagplt.Controller;

import com.example.ofrstagplt.Entities.Offre;
import com.example.ofrstagplt.Service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Remplacez "http://localhost:4200" par l'URL de votre application Angular

public class OffreController {
@Autowired
OffreService offreService;

@PostMapping("/add-offre")
@ResponseBody
public void ajouterUnOffre(@RequestBody Offre offre){
offreService.ajouterUnOffre(offre);
}

@DeleteMapping("/delete-offre/{id}")
public ResponseEntity<String> supprimerOffre(@PathVariable Long id) {
    try {
        // Appelez le service pour supprimer l'offre par ID
        offreService.supprimerUnOffre(id);
        return new ResponseEntity<>("Offre supprimée avec succès", HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Erreur lors de la suppression de l'offre : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@GetMapping("/get-offre")
    List<Offre> afficherAllOffre(){
    return offreService.afficherAllOffre();
    }

    @GetMapping("/get-offre/{type}")
    @ResponseBody
    List<Offre>  afficherOffreParType(@PathVariable String type){
    return offreService.afficherOffreParType(type);
    }

    @PutMapping("/update-offre/{id}")
    public ResponseEntity<Offre> updateOffre(@PathVariable Long id, @RequestBody Offre updatedOffre) {
        Offre offre = offreService.updateOffre(id, updatedOffre);
        if (offre != null) {
            return ResponseEntity.ok(offre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//@PostMapping("/update-offre")
//@ResponseBody
//public void modifierUnOffre(@RequestBody Long id, @RequestBody Offre offre){
//
}
