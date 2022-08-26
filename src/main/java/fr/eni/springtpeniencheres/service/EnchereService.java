package fr.eni.springtpeniencheres.service;

import fr.eni.springtpeniencheres.bo.Article;
import fr.eni.springtpeniencheres.bo.Enchere;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EnchereService {

    public void addEnchere(Enchere enchere) throws Exception;

    public List<Enchere> listeEnchere();

    public Enchere getEnchereById(long id);

    public List<Enchere> getEncheresByArticle(Article article);

    public Enchere getLastEnchere(long id);

    public boolean checkDateEnchere(LocalDateTime dateCreaEnchere, LocalDate dateFinEnchere);


}
