package fr.eni.springtpeniencheres.service;

import fr.eni.springtpeniencheres.bo.Categorie;

import java.util.List;

public interface CategorieService {

    public void addCategorie(Categorie categorie) throws Exception;

    public List<Categorie> listeCategories();

    public Categorie getCategorieById(long id);

}
