package fr.eni.springtpeniencheres.converter;

import fr.eni.springtpeniencheres.bo.Retrait;
import fr.eni.springtpeniencheres.bo.Retrait;
import fr.eni.springtpeniencheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class RetraitConverter implements Converter<String, Retrait> {

    @Autowired
    private RetraitService retraitService;


    @Override
    public Retrait convert(String idAuFormatTexte) {
        long id = Integer.parseInt(idAuFormatTexte);
        return retraitService.getRetraitById(id);
    }

}
