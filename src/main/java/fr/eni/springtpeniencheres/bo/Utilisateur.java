package fr.eni.springtpeniencheres.bo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity @Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noUtilisateur;
    @NotEmpty
    private String pseudo;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @NotEmpty
    private String email;
    @NotEmpty
    private String telephone;
    @NotEmpty
    private String rue;
    @NotEmpty
    private String codePostal;
    @NotEmpty
    private String ville;
    @NotEmpty
    private String motDePasse;
    @NotEmpty
    private int credit = 0;
    private Boolean administrateur;

    public Utilisateur() {
    }

    /**
     * Permet l'échange de points lors de la fin d'une enchere, du point de vu de
     * l'acheteur
     *
     * @param noArticle Numéro de l'article concerné.
     */
    public int achete(int noArticle) {

        int resultat = 0;

        return resultat;
    }

    /**
     *
     * Permet l'échange de points lors de la fin d'une enchere, du point de vu du
     * vendeur.
     *
     */
    public int vend(int noArticle) {

        int resultat = 0;

        return resultat;
    }


}
