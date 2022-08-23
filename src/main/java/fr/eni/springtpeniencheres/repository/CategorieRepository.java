package fr.eni.springtpeniencheres.repository;

import fr.eni.springtpeniencheres.bo.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    // TODO remove later if not used
    public Categorie findByLibelle(String libelle);

    public boolean existsByLibelle(String libelle);

}
