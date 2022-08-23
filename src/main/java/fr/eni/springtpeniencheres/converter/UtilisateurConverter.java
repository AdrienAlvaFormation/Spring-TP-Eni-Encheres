package fr.eni.springtpeniencheres.converter;

import fr.eni.springtpeniencheres.bo.Utilisateur;
import fr.eni.springtpeniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurConverter implements Converter<String, Utilisateur> {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public Utilisateur convert(String idAuFormatTexte) {
        long id = Integer.parseInt(idAuFormatTexte);
        return utilisateurService.getUtilisateurById(id);
    }

}
