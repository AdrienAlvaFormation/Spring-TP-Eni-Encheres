package fr.eni.springtpeniencheres.security;

import fr.eni.springtpeniencheres.bo.Utilisateur;
import fr.eni.springtpeniencheres.service.UtilisateurService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UtilisateurService utilisateurService;

    public MyUserDetailsService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        Utilisateur utilisateur = utilisateurService.getUtilisateurByPseudo(username);

        if (utilisateur == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new UtilisateurAuth(utilisateur);
        }
    }
}
