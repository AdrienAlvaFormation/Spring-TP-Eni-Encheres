package fr.eni.springtpeniencheres.api;

import fr.eni.springtpeniencheres.bo.Utilisateur;
import fr.eni.springtpeniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/utilisateurs")
public class UtilisateurRestController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getListUtilisateur(){

        System.out.println("GET api/utilisateur");
        return utilisateurService.listeUtilisateur();
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable long id){
        return utilisateurService.getUtilisateurById(id);
    }


    @PostMapping
    public Utilisateur postUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception {

        System.out.println("POST api/utilisateur");

        System.out.println(utilisateur);

        utilisateurService.addUtilisateur(utilisateur);

        return utilisateur;
    }



}
