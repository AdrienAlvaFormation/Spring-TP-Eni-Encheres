package fr.eni.springtpeniencheres.bo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity @Data
public class Retrait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
    NotBlank mieux que NotEmpty car l'utiilisateur ne peut pas mettre des espaces.
     */
    @NotBlank
    private String rue;
    @NotBlank
    private String code_postal;
    @NotBlank
    private String ville;
}
