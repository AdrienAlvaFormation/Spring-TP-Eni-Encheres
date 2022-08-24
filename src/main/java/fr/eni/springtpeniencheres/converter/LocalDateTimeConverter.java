package fr.eni.springtpeniencheres.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {


    @Override
    public LocalDateTime convert(String dateAuFormatTexte) {
        System.out.println("Je tente de convertir un date-time");
        return LocalDateTime.parse(dateAuFormatTexte);
    }
}
