package fr.eni.springtpeniencheres.api;

import fr.eni.springtpeniencheres.bo.Article;
import fr.eni.springtpeniencheres.bo.Enchere;
import fr.eni.springtpeniencheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/encheres")
public class EnchereRestController {

    @Autowired
    private EnchereService enchereService;

    @GetMapping
    public List<Enchere> getListEnchere(){

        System.out.println("GET api/enchere");
        return enchereService.listeEnchere();
    }

    @GetMapping("/{id}")
    public Enchere getEnchereById(@PathVariable long id){
        return enchereService.getEnchereById(id);
    }

    // Todo for testing only - delete on prod
    @GetMapping("/article/{id}")
    public List<Enchere> getEnchereArticle(@PathVariable long id){

        Article article = new Article();
        article.setNoArticle(id);

        return enchereService.getEncheresByArticle(article);
    }

    @PostMapping
    public Enchere postEnchere(@RequestBody Enchere enchere) throws Exception {

        System.out.println("POST api/enchere");

        System.out.println(enchere);

        enchereService.addEnchere(enchere);

        return enchere;
    }

    @GetMapping("/max-enchere/{id}")
    public Enchere getMaxEnchere(@PathVariable long id){

        Article article = new Article();
        article.setNoArticle(id);

        return enchereService.getLastEnchere(id);

    }
}
