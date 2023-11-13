package tn.sae.offre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sae.offre.entity.Offre;
import tn.sae.offre.service.OffreService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/offre")
@RequiredArgsConstructor
public class OffreController {
    @Autowired
    OffreService offreService;
    @PostMapping("/add")
    @ResponseBody
    void addOffre(@RequestBody Offre offre) {
        offreService.addOffre(offre);
    }
    @GetMapping("/ShowAll")
    @ResponseBody
    List<Offre> getAllOffres(){
        return offreService.getAllOffres();
    }
    @GetMapping("/titre/{titre}")
    @ResponseBody
    List<Offre> getOffreByTitre(@PathVariable("titre") String titre){
        return offreService.getOffreByTitre(titre);
    }
    @GetMapping("/type/{type}")
    @ResponseBody
    List<Offre> getOffreByType(@PathVariable("type") String type){
        return offreService.getOffreByType(type);
    }
    @DeleteMapping("/remove/{idOffre}")
    @ResponseBody
    public Map<String, Boolean> DeleteOffreById(@PathVariable(value ="idOffre") Integer idOffre){
        offreService.DeleteOffreById(idOffre);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public void UpdateOffreById(@PathVariable(value = "id") Integer id, @RequestBody Offre offre){
        offreService.UpdateOffreById(id,offre);
    }

}
