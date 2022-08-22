package fr.eni.springtpeniencheres.bo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int noArticle;
    private String nomArticle;
    private String description;
    private LocalDate dateDebutEncheres;
    private LocalDate dateFinEncheres;
    private int miseAPrix;
    private int prixVente;
    private String etatVente;
    @ManyToOne
    private Utilisateur vendeur;
    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private Retrait retrait;
    @OneToMany
    private List<Enchere> encheres;

}
