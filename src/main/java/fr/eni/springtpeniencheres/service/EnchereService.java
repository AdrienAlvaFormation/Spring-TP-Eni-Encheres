package fr.eni.springtpeniencheres.service;

import fr.eni.springtpeniencheres.bo.Enchere;
import fr.eni.springtpeniencheres.bo.Utilisateur;

import java.util.List;

public interface EnchereService {

    public void addEnchere(Enchere enchere) throws Exception;

    public List<Enchere> listeEnchere();

    public Enchere getEnchereById(long id);

    public List<Enchere> listeEnchereByNoArticle(long noArticle);

}
