package fr.eni.springtpeniencheres.service.impl;

import fr.eni.springtpeniencheres.bo.Categorie;
import fr.eni.springtpeniencheres.repository.CategorieRepository;
import fr.eni.springtpeniencheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceJpaImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;


    @Override
    public void addCategorie(Categorie categorie) throws Exception {
        
        if (categorieRepository.existsByLibelle(categorie.getLibelle())) {
            throw new Exception("Categorie déjà existante");
        }

        categorieRepository.save(categorie);

    }

    @Override
    public List<Categorie> listeCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorieById(long id) {
        return categorieRepository.findById(id).get();
    }
}
