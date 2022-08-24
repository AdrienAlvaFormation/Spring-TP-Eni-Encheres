package fr.eni.springtpeniencheres.bo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity @Data
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime dateEnchere;
    @NotEmpty
    private int montant_enchere;
    @ManyToOne
    private Utilisateur encherisseur;
    @ManyToOne //@JoinColumn(name="no_article")
    private Article article;
}
