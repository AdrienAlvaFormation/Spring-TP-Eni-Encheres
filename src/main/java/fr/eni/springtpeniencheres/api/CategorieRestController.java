package fr.eni.springtpeniencheres.api;

import fr.eni.springtpeniencheres.bo.Categorie;
import fr.eni.springtpeniencheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategorieRestController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getListCategories(){

        System.out.println("GET api/categories");
        return categorieService.listeCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable long id){
        return categorieService.getCategorieById(id);
    }


    @PostMapping
    public Categorie postCategorie(@RequestBody Categorie categorie) throws Exception {

        System.out.println("POST api/categories");

        System.out.println(categorie);

        categorieService.addCategorie(categorie);

        return categorie;
    }

}
