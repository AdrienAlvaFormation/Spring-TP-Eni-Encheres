package fr.eni.springtpeniencheres.bo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int noUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String rue;
    private String codePostal;
    private String ville;
    private String motDePasse;
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
     * @param noArticle
     */
    public int vend(int noArticle) {

        int resultat = 0;

        return resultat;
    }


}
