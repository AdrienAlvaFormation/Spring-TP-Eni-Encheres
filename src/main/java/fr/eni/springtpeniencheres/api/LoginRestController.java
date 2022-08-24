package fr.eni.springtpeniencheres.api;

import fr.eni.springtpeniencheres.bo.Utilisateur;
import fr.eni.springtpeniencheres.security.JwtUtils;
import fr.eni.springtpeniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginRestController {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @PostMapping
    public String login(@RequestBody Utilisateur utilisateur) throws Exception {

        System.out.println(utilisateur);

        Utilisateur userBDD = utilisateurService.getUtilisateurByPseudo(utilisateur.getPseudo());

        System.out.println(userBDD);

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userBDD.getPseudo(),
                utilisateur.getMotDePasse());
        Authentication authentication = authenticationConfiguration.getAuthenticationManager()
                .authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return jwt;
    }
}
