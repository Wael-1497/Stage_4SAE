package tn.sae.partnership.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sae.partnership.entity.Partnership;
import tn.sae.partnership.service.PartnershipService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/partnership")
@RequiredArgsConstructor
public class PartnershipController {
    @Autowired
    PartnershipService partnershipService;
    @PostMapping("/add-part/{idEvenement}")
    @ResponseBody
    void addPartenariat(@RequestBody Partnership partenaire, @PathVariable int idEvenement) {
        partnershipService.addPartenariat(partenaire, idEvenement);
    }
    @GetMapping("/all-part")
    @ResponseBody
    List<Partnership> getAllPartenariats(){
        return partnershipService.getAllPartenariats();
    }
    @GetMapping("/part/{idPartnership}")
    @ResponseBody
    Partnership getPartnershipById(@PathVariable("idPartnership") Integer idPartnership){
        return partnershipService.getPartnershipById(idPartnership);
    }
    @DeleteMapping("/delete-part/{idPartnership}")
    @ResponseBody
    public Map<String, Boolean> DeletePartnershipById(@PathVariable(value ="idPartnership") Integer idPartnership){
        partnershipService.DeletePartnershipById(idPartnership);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/update-part/{id}")
    @ResponseBody
    public void UpdatePartnershipById(@PathVariable(value = "id") Integer id, @RequestBody Partnership partnership){
        partnershipService.UpdatePartnershipById(id,partnership);
    }
}
