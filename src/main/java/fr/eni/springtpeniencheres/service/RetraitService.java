package fr.eni.springtpeniencheres.service;

import fr.eni.springtpeniencheres.bo.Categorie;
import fr.eni.springtpeniencheres.bo.Retrait;

public interface RetraitService {

    public void addRetrait(Retrait retrait) throws Exception;

    public Retrait getRetraitById(long id);


}
