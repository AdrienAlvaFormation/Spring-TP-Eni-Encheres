package fr.eni.springtpeniencheres.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private int montantEnchere;
    @ManyToOne
    private Utilisateur encherisseur;
    @ManyToOne
    @JsonBackReference
    private Article article;
}
