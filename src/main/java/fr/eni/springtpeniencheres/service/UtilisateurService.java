package fr.eni.springtpeniencheres.service;

import fr.eni.springtpeniencheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    public boolean addUtilisateur(Utilisateur utilisateur) throws Exception;

    public List<Utilisateur> listeUtilisateur();

    public Utilisateur getUtilisateurById(long id);

    public Utilisateur getUtilisateurByPseudo(String pseudo);

    public void updateUtilisateur(Utilisateur utilisateur) throws Exception;

}
