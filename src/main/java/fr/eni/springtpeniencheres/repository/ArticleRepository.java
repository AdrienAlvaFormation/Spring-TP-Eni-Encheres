package fr.eni.springtpeniencheres.repository;

import fr.eni.springtpeniencheres.bo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public Article findByNomArticle(String nomArticle);

    public boolean existsByNomArticle(String nomArticle);



}
