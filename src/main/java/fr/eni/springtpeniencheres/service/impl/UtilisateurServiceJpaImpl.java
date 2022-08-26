package fr.eni.springtpeniencheres.service.impl;

import fr.eni.springtpeniencheres.bo.Utilisateur;
import fr.eni.springtpeniencheres.repository.UtilisateurRepository;
import fr.eni.springtpeniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilisateurServiceJpaImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /*
     * Il y a un @Bean présent dans le contexte Spring pour le type
     * PasswordEncoder ( fait dans WebSecurityConfig)
     * Je vais donc pouvoir l'injecter dans ma classe
     */
    @Autowired
    PasswordEncoder passwordEncoder; //utilitaire d'encodage des mots de passe


    @Override
    public boolean addUtilisateur(Utilisateur utilisateur) throws Exception {

        boolean isOkToAdd;

        if (validateNewUser(utilisateur)) {

            String motDePasseEncode = passwordEncoder.encode(utilisateur.getMotDePasse());
            utilisateur.setMotDePasse(motDePasseEncode);

            utilisateurRepository.save(utilisateur);

            System.out.println("USER OK TO ADD");

            isOkToAdd = true;

        } else {

            System.out.println("PSEUDO NOT AVAILABLE");

            isOkToAdd = false;

        }

        return isOkToAdd;

    }

    public void updateUtilisateur(Utilisateur utilisateur) throws Exception {

        utilisateurRepository.save(utilisateur);

    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public Utilisateur getUtilisateurByPseudo(String pseudo) {
        return utilisateurRepository.findByPseudo(pseudo);
    }

    // UTILS

    private boolean validateNewUser(Utilisateur utilisateur) {

        boolean isOK;

        if (!utilisateurRepository.existsUtilisateurByPseudo(utilisateur.getPseudo()) &&
            !utilisateurRepository.existsUtilisateurByEmail(utilisateur.getEmail())) {

            isOK = true;

        } else {
            isOK = false;
        }

        return isOK;
    }// Eo validateNewUser()


}
