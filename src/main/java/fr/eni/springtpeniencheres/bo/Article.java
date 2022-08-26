package fr.eni.springtpeniencheres.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noArticle;
    @NotEmpty
    private String nomArticle;
    @NotEmpty
    private String description;
//    @NotEmpty
    private LocalDate dateDebutEncheres;
//    @NotEmpty
    private LocalDate dateFinEncheres;

    @NotEmpty
    private int miseAPrix;

    private int prixVente;

    private String etatVente;

    @ManyToOne @JoinColumn(name="vendeur_id")
    private Utilisateur vendeur;

    @ManyToOne @JoinColumn(name="no_categorie")
    private Categorie categorie;

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name="retrait_id")
    private Retrait retrait;
    @OneToMany //@JoinColumn(name="id_article")
    @JsonManagedReference
    private List<Enchere> encheres;

    public Article() {
        encheres = new ArrayList<>();
    }

}
