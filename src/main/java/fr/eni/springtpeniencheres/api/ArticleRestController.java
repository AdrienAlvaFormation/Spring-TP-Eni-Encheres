package fr.eni.springtpeniencheres.api;

import fr.eni.springtpeniencheres.bo.Article;
import fr.eni.springtpeniencheres.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/articles")
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getListArticles(){

        System.out.println("GET api/articles");

        return articleService.listeArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id){

        System.out.println("GET api/articles/{id}");

        return articleService.getArticleById(id);
    }


    @PostMapping
    public Article postArticle(@RequestBody Article article) throws Exception {

        System.out.println("POST api/articles");

        articleService.addArticle(article);

        return article;
    }

}
