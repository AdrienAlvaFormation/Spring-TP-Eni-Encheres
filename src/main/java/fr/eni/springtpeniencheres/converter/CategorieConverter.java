package fr.eni.springtpeniencheres.converter;

import fr.eni.springtpeniencheres.bo.Categorie;
import fr.eni.springtpeniencheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategorieConverter implements Converter<String, Categorie> {

    @Autowired
    private CategorieService categorieService;

    /**
     * On doit coder explicitement comment on passe d'une date au format texte => format Categorie
     */
    @Override
    public Categorie convert(String idAuFormatTexte) {
        long id = Integer.parseInt(idAuFormatTexte);
        return categorieService.getCategorieById(id);
    }

}
