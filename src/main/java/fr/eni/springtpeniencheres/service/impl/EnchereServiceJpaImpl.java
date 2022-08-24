package fr.eni.springtpeniencheres.service.impl;

import fr.eni.springtpeniencheres.bo.Article;
import fr.eni.springtpeniencheres.bo.Enchere;
import fr.eni.springtpeniencheres.repository.ArticleRepository;
import fr.eni.springtpeniencheres.repository.EnchereRepository;
import fr.eni.springtpeniencheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceJpaImpl implements EnchereService {

   @Autowired
   private EnchereRepository enchereRepository;


    @Override
    public void addEnchere(Enchere enchere) throws Exception {
        enchereRepository.save(enchere);
    }

    @Override
    public List<Enchere> listeEnchere() {
        return enchereRepository.findAll();
    }

    @Override
    public Enchere getEnchereById(long id) {
        return enchereRepository.findById(id).get();
    }

    @Override
    public List<Enchere> getEncheresByArticle(Article article) {
        return enchereRepository.findByArticle(article);
    }


}
