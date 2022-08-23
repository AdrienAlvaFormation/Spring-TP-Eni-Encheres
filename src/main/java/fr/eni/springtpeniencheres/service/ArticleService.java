package fr.eni.springtpeniencheres.service;

import fr.eni.springtpeniencheres.bo.Article;

import java.util.List;

public interface ArticleService {

    public void addArticle(Article article) throws Exception;

    public List<Article> listeArticles();

    public Article getArticleById(long id);

}
