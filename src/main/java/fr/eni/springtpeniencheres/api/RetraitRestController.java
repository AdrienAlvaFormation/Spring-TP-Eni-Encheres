package fr.eni.springtpeniencheres.api;

import fr.eni.springtpeniencheres.bo.Categorie;
import fr.eni.springtpeniencheres.bo.Retrait;
import fr.eni.springtpeniencheres.service.CategorieService;
import fr.eni.springtpeniencheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/retrait")
public class RetraitRestController {

    @Autowired
    private RetraitService retraitService;

    @GetMapping("/{id}")
    public Retrait getRetraitById(@PathVariable long id){
        return retraitService.getRetraitById(id);
    }

    @PostMapping
    public Retrait postRetrait(@RequestBody Retrait retrait) throws Exception {

        System.out.println("POST api/retrait");

        System.out.println(retrait);

        retraitService.addRetrait(retrait);

        return retrait;
    }


}
