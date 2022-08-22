package fr.eni.springtpeniencheres.bo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity @Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int noArticle;
    @NotEmpty
    private String nomArticle;
    @NotEmpty
    private String description;
    @NotEmpty
    private LocalDate dateDebutEncheres;
    @NotEmpty
    private LocalDate dateFinEncheres;
    @NotEmpty
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
