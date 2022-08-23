package fr.eni.springtpeniencheres.service;

import fr.eni.springtpeniencheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    public void addUtilisateur(Utilisateur utilisateur) throws Exception;

    public List<Utilisateur> listeUtilisateur();

    public Utilisateur getUtilisateurById(long id);
}
