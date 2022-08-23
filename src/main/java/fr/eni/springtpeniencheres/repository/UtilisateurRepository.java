package fr.eni.springtpeniencheres.repository;

import fr.eni.springtpeniencheres.bo.Categorie;
import fr.eni.springtpeniencheres.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    public boolean existsById(long id);
}
