package fr.eni.springtpeniencheres.service.impl;

import fr.eni.springtpeniencheres.bo.Utilisateur;
import fr.eni.springtpeniencheres.repository.UtilisateurRepository;
import fr.eni.springtpeniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilisateurServiceJpaImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public void addUtilisateur(Utilisateur utilisateur) throws Exception {

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
}
