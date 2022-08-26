package fr.eni.springtpeniencheres.repository;

import fr.eni.springtpeniencheres.bo.Article;
import fr.eni.springtpeniencheres.bo.Categorie;
import fr.eni.springtpeniencheres.bo.Enchere;
import fr.eni.springtpeniencheres.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // EXISTS
    public boolean existsById(long id);
    public boolean existsUtilisateurByPseudo(String pseudo);
    public boolean existsUtilisateurByEmail(String email);

    // FIND BY
    public Utilisateur findByPseudo(String pseudo);


}
