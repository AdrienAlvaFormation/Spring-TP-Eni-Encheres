package fr.eni.springtpeniencheres.service.impl;

import fr.eni.springtpeniencheres.bo.Article;
import fr.eni.springtpeniencheres.repository.ArticleRepository;
import fr.eni.springtpeniencheres.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceJpaImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public void addArticle(Article article) throws Exception {

        System.out.println(article);

        if (articleRepository.existsByNomArticle(article.getNomArticle())) {
            throw new Exception("Article déjà existant");
        }

        articleRepository.save(article);

    }

    @Override
    public List<Article> listeArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(long id) {
        return articleRepository.findById(id).get();
    }

}
