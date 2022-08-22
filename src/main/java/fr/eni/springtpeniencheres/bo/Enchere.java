package fr.eni.springtpeniencheres.bo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Data
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime dateEnchere;
    private int montant_enchere;
    @ManyToOne
    private Utilisateur encherisseur;
}
